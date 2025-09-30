package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/insert.board")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩 설정(UTF-8)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값 뽑기
		//String title = request.getParameter("title");
		//System.out.println(title);
		
		// form 태그 요청시 multipart/form-data형식으로 전송한 경우
		// request.getParameter로는 값을 뽑아낼 수 없음
		
		// 스텝 0) 요청이 multipart방식으로 잘 왔는가?
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 스텝 1) 전송된 파일을 위한 작업
			// 1_1. 전송파일 용량 제한
			/*
			 * 단위 정리
			 * 
			 * bit => 0 또는 1이 들어갈 수 있는 한 칸
			 * bit X 8 => Byte => 1024개 모으면 KByte => 1024개 모으면 MByte => GByte => 1024개 모으면 TByte => 1024개 모으면 PByte => 1024개 모으면 ....
			 * 
			 * 10MegaByte
			 * 
			 */
			int maxSize = 10 * 1024 * 1024; // 10메가바이트 표현
			
			// 1_2. 서버의 저장할 폴더 경로 알아내기
			// pageContext
			// HttpServletRequest
			// 리퀘스트 스코프는 요청 받은 서블릿의 do 포스트 어쩌구부터 응답 만들어주는 포워딩 jsp 까지 접근 가능
			// HttpSession
			// 세션 스코프는
			// ServletContext (애플리케이션 스코프라고 부름)
			// getRealPath()
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/board_upfiles"); // 자기 경로를 얻어내는 방법
			// System.out.println(savePath); // 물리적 경로가 나오네?
			// 장점
			// 동적으로 실제 경로 확인
			// 서버환경에 관계없이 동작
			// 단점
			// WAR파일 배포 시 파일이 사라질 수 있음
			
			// 스텝 2) 파일 업로드 하기
			// a.jpg  a2.jpg a3.jpg 넘버링 겁나구려~
			// kakaoTalk_ 20241205_ 181108   376    .jpg
			/*
			 * HttpServletRequest
			 * =>
			 * MultipartRequest객체로 변환
			 * 이관함
			 * [ 표현법 ]
			 * MultipartRequest multiRequest =
			 * new MultiRequest(request, 저장경로, 용량제한, 인코딩방식, 파일명을 수정해주는 객체);
			 * 
			 * Multipart객체를 생성하면 파일이 업로드!
			 * 
			 * 사용자가 올린 파일명은 이름을 바꿔서 업로드 하는 게 일반적인 관례
			 * 
			 * Q) 파일명은 왜 바꾸나요?
			 * A) 똑같은 파일명 있을 수 있으니까
			 *    파일명에 한글 / 특수문자 / 공백문자 포함경우 서버에 따라 문제가 발생
			 *    
			 */
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());
			
			// -- 파일업로드 --
			// BOARD 테이블에 INSERT 하기
			// 2) 값 뽑기 (여기부터 다시)
			String title = multiRequest.getParameter("title");
			//System.out.println(title);
			String content = multiRequest.getParameter("content");
			String category = multiRequest.getParameter("category");
			
			Long userNo = ((Member)session.getAttribute("userInfo")).getUserNo();
			
			// 3) 가공해야지~!
			Board board = new Board();
			board.setBoardTitle(title);
			board.setBoardContent(content);
			board.setCategory(category);
			board.setBoardWriter(String.valueOf(userNo));
			// 파일 정보는 attachment 테이블에 넣는다.
			
			// 3_2) 첨부파일의 경우 => 선택적
			Attachment at = null;
			
			// 첨부파일이 있는지 없는지 파악
			// System.out.println(multiRequest.getOriginalFileName("upfile"));
			// 첨부파일이 있다면 "원본파일명" / 없다면 null값을 반환
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				// 첨부파일이 있다!!!!!! => VO로 만들기
				 at = new Attachment();
				
				// originName
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				
				// changeName
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				
				// filePath
				at.setFilePath("resources.board_upfiles");
			} 
			
			// 4) 요청처리 Service 호출
			new BoardService().insert(board, at);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
