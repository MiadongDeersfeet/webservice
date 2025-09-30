package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.vo.PageInfo;

@WebServlet("/boards")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워딩 하기 전에 DB 가서 게시글 SELECT 해서 setAttribute 해서 화면에서 뿌릴 거라구요~!
		// 페이징 처리 (한 페이지에 보여주고 싶은 개수만큼)
		// - 페이징 처리 -
		// 필요한 변수들
		int listCount; // 현재 테이블에 있는 총 게시글 개수 (버튼을 몇개 만들지 정할 수 있음) => 30개
		// => BOARD 테이블에서 COUNT(*) 그룹함수--행개수 몇개인지 (STATUS='Y' AND BOARD_TYPE = 1) 안지워진거'Y' + 일반게시판'1'
		int currentPage; // 현재 사용자가 요청한 페이지 -- page=80 이런식 // 알아내는법 => 앞단에서 넘겨줘야함 버튼에 달아서 // 앞단에서 넘겨주는거 URL에 키밸류로 찍힌 거
		// 뒤에서 어떻게 해줘요 ? => request.getParamete("page")로 뽑아서 씀
		// String page = request.getParameter("page");
		// System.out.println(page);
		int pageLimit; // 페이지 하단에 페이징버튼 개수를 몇 개 보여줄건지 정해야합니다.-> 5개
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 개수 -> 10개
		
		int maxPage; // 가장 마지막 페이지가 몇 번 페이지인지(총 페이지의 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
		
		// * listCount : 총 게시글의 수
		listCount = new BoardService().selectListCount();
		//System.out.println(listCount);
		currentPage = Integer.parseInt(request.getParameter("page"));
		//System.out.println(currentPage);
		
		pageLimit = 3; // 나중에 5로 다시 바꾸자~!
		boardLimit = 5;
		
		//* maxPage : 가장 마지막 페이지가 몇 번 페이지인지
		/*
		 * listCount, BoardLimit 을 가지고 maxPage를 구했어요.
		 * 
		 * - 공식 구하기
		 *   단, boardLimit이 10이라고 가정
		 *   
		 * 총 개수     한 페이지       나눗셈 결과       마지막페이지
		 *  100    /    10      =      10              10
		 *  107    /    10      =      10.7            11 
		 *  111    /    10      =      11.1            12
		 * 
		 * int, int이기 때문에 결과는 int로밖에 나올 수 없어요.
		 * 만약에 소수점으로 결과가 나왔을 시 올림처리를 해주면 마지막페이지 수가 나오겠죠?
		 * => 나눗셈(listCount / boardCount)의 결과를 올림처리 할 경우 maxPage 가 나옴
		 * 
		 * 스텝
		 * 1. listCount를 double로 변환
		 * 2. listCount / boardLimit
		 * 3. 결과를 올림처리 => Math.ceil()
		 */
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// * startPage : 페이지 하단에 보여질 페이징 버튼 중 시작값 -- 계속해서 변화합니다.
		/*
		 * currentPage, pageLimit의 영향을 받음
		 * 
		 * - 공식 구하기
		 *   단, pageLimit이 10이라고 가정
		 *   
		 * startPage : 1, 11, 21, 31 ... => n * 10 + 1 (동차수열)
		 * 
		 * 만약에 pageLimit이 5라고 가정하면?
		 * 
		 * startPage : 1, 6, 11, 16 ... => n * 5 + 1
		 * 
		 * 즉, startPage == n * pageLimit + 1;	
		 * 
		 * currentPage   startPage
		 *     1             1
		 *     5             1
		 *     10            1
		 *     11            11
		 *     13            11              
		 *     17            11
		 *     20            11
		 *     21            21
		 *     30            21
		 *     31            31
		 * 
		 *    1 ~ 10 / 10(pageLimit) => 0 ~ 1
		 *   11 ~ 20 / 10            => 1 ~ 2
		 *   21 ~ 30 / 10            => 2 ~ 3
		 *(여기 -1 해주면)
		 *    0 ~ 9  / 10 => 0
		 *    10 ~ 19 / 10 => 1
		 *    20 ~ 29 / 10 => 2 
		 *    
		 * n = (currentpage - 1) / pageLimit
		 *
		 * startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		 */
		startPage = (currentPage -1) / pageLimit * pageLimit + 1;
		
		// * endPage : 페이지 하단에 보여질 페이지 버튼의 끝 수
		/*
		 * startPage, pageLimit의 영향을 받음
		 * (maxPage도 영향을 끼침)
		 * 
		 * - 공식을 생각해보자
		 *   단, pageLimit이 10이라는 가정
		 *   
		 * startPage : 1 => endPage : 10
		 * startPage : 21 => endPage : 30
		 *   
		 * enPage = startPage + pageLimit - 1;
		 * 
		 * 
		 */
		endPage = startPage + pageLimit - 1;
		
		// startPage가 1이라서 endPage에 지금 10이 들어있는데
		// maxPage가 6이라면?? (7~10에서는 보여줄 게 없잖아요.)
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		int offset = (currentPage - 1) * boardLimit;
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, startPage, endPage, maxPage, offset);
		// System.out.println(pi);
		
		List<Board> boards = new BoardService().selectBoardList(pi);
		
		// System.out.println(boards);
		
		// pi랑 boards랑 보내줘야함 --> 우째요?
		
		request.setAttribute("pi", pi);
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp")
		       .forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
