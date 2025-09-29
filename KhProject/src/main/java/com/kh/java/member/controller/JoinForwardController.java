package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinForwardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinForwardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 나 할 일 뭐임?? 나 뭐해야됨??
		// 회원가입 양식 띄워주기 쩌기 enroll_form.jsp가 응답하게 만들기
		// 서블릿에서 응답데이터 지정하는 방식 두 가지
		// 1. RequestDispatcher 이용해서 forwarding 해주기
		// 2. response 이용해서 sendRedirect
		// 지금 상황에서는 선택지가 없어요. 왜? 지금은 enroll_form.jsp로 갈 수 있는 방법이 없어요. 그래서 포워딩 방식을 써야합니다.
		
		request.getRequestDispatcher("/WEB-INF/views/member/enroll_form.jsp")
		       .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
