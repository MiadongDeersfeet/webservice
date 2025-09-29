package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/myPage")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내정보 조회란 뭘까?
		
		// 로그인 여부를 확인하려면 세션 스코프의 로그인 유저를 담아놓는 UserInfo 키값을 봐야해요.
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("userInfo");
		Member userInfo = new MemberService().login(member);
		
		if(userInfo != null) { 
			session.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("/WEB-INF/views/member/my_page.jsp")
		       .forward(request, response);
		} else {
			request.setAttribute("msg", "로그인 다시 하셈 ㅋ");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp")
			       .forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
