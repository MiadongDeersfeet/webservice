package com.kh.java.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;

@WebServlet("/detail.board")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 항상 내가 뭘 해야하는지 뭘하고 있는지 생각하자 -- 인지부채를 줄이자 (정보처리과정의 외주화)
		
		// 일단 KH_BOARD에서 게시글 내용 조회하고
		// 첨부파일은 KH_ATTACHMENT에서 조회해가야겠다.
		
		// GET방식
		// 현재 클릭한 게시글의 boardNo 를 넘겼고 이걸 뽑아내는 게 선행되어야 하는 작업이예요.
		int boardNo = Integer.parseInt(request.getParameter("boardNo")); // 2
		
		// 가공할 건 없음
		
		// 요청처리 -> 서비스단으로 boardNo 넘김
		Map<String, Object> map = new BoardService().selectBoard(boardNo); // 3
		String path ="";
		// 성공실패
		if(map != null) {
		request.setAttribute("map", map); // 4
		/*
		request.getRequestDispatcher("/WEB-INF/views/board/board_detail.jsp").forward(request, response); // 1
		*/
		path = "board/board_detail";
		} else {
			request.setAttribute("msg", "게시글이 읎으요"); // 5
			/*
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
			*/
		}
		
		request.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp").forward(request, response);
		path = "common/result_page";
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
