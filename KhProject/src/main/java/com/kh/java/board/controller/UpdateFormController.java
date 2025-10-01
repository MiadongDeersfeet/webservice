package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Category;

@WebServlet("/updateForm.board")
public class UpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 시~원하게 해 보겠 읍 니다~~~~~~~~~~~~ 수정하기 ~~
		// 자 일다 ㄴ슬랙에 수업자료 탭에서 update_form.html을 가져오시기 바랍니다 ~
		
		// 게시글 수정양식 보여주기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// boardNo 들고 DB 가야지 => 보드도 땡겨오고, 첨부파일도 땡겨오고, 카테고리도 땡겨오고 ... 셀렉트를 3번은 해야하는 거지 ...
		
		// 조회수 1 증가한다는 점 고려하면 방법을 고민해봐야겠는데....
		
		BoardService boardService = new BoardService();
		
		List<Category> category = boardService.selectCategory();
		Map<String, Object> map = boardService.selectBoard(boardNo);
		
		request.setAttribute("category", category);
		request.setAttribute("map", map);
		
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/update_form.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
