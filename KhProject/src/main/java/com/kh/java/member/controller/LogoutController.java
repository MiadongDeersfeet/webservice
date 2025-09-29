package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃을 구현해야함.
		// 로그아웃이란 뭘까?
		// session의 userInfo라는 속성을 null이거나 지우거나
		// request.getSession().removeAttribute("userInfo"); 하거나
		// session 만료시키는 방법 (==무효화한다)
		// 주의할 점으로 아래 방법은 요 세션에 있는 건 다 날아가는 거예요.
		request.getSession().invalidate();
		request.getSession().setAttribute("alertMsg", "안녕히가세요.");
		
		// 응답데이터 => 웰컴파일
		// 포워딩 방식이 있고 센드리다이렉트 방식이 있겠네요?
		// sendRedirect()
		// System.out.println(request.getContextPath()); <= 얘가 반환타입이 스트링이거든요. 이 스트링값을 어떻게 쓰면 될까요?
		response.sendRedirect(request.getContextPath());
		// 컨텍스트 루트 적어주면 웰컴파일 받을 수 있어요.
		// 멋있어.
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
