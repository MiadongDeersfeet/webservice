package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * <HttpServletRequest, HttpServletResponse>
		 * 
		 * - request : 서버로 요청을 보낼 때의 정보(요청 시 전달값, 요청 전송방식, 사용자정보)
		 * - response : 요청에 대한 응답데이터를 만들 때 사용
		 * 
		 * 값 => data 를 의미하고
		 * 정보 => date 중에서 의미가 있는 것들
		 */
		
		// 절차
		// 1) GET? POST? => 요청 방식이 POST 방식이라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값이 있나? 없나? => POST는 무조건 해야함
		// request.getParameter("키값") : String
		// request.getParameter("키값") : String[]
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userPwd);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
