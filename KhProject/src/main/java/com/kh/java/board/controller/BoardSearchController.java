package com.kh.java.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.vo.PageInfo;

@WebServlet("/search.board")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 선택한 옵션과 사용자가 입력한 키워드를 가지고
		// DB상에서 검색해서 나온 조회 결과를
		// 페이징처리까지 끝내서 들고 갈 것
		
		String condition = request.getParameter("condition");
		// "writer", "title", "content" 가 오거나 ....
		String keyword = request.getParameter("query");
		// 사용자가 입력한 값
		
		// 원, 투 어디에 담아줄까요 ? => 맵
		Map<String, Object> map = new HashMap();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		// 페이징하려면 필요한 것 1. 전체게시글수 2. 현재요청페이지 3. 한번에보여줄페이징버튼개수 4. 한번에보여줄게시글개수 5.maxPage 6.시작페이지 7.마지막페이지 8.오프셋
		int listCount = new BoardService().searchedCount(map); // 무얼 조건으로 했는지, 키워드는 뭔지 .. 위에 변수 1, 2를 담아줘야함.
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageLimit = 5;
		int boardLimit = 5;
		int maxPage = (int)(Math.ceil((double)listCount / boardLimit));
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		int offset = (currentPage - 1) * boardLimit;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 아 이거 중복코드.. 아 이거 책임분리 아 이거... 아으아아아아ㅏ아!!!
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, startPage, endPage, maxPage, offset);
		
		// SELECT 할 때 OFFSET 구문 쓰려면 무엇이 필요하다 ? => 
		// OFFSET ? RO
		
		map.put("offset", offset);
		map.put("limit", boardLimit);
		
		List<Board> boards = new BoardService().selectSearchList(map);
		
		request.setAttribute("boards", boards);
		request.setAttribute("pi", pi);
		request.setAttribute("keyword", keyword);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
