package com.yk.school.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yk.school.model.service.StudentService;
import com.yk.school.model.vo.Student;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		// 전달값 존재 여부 확인 (POST는 필수)
		String studentId = request.getParameter("studentId");
		String studentPwd = request.getParameter("studentPwd");
		
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPwd(studentPwd);
		
		// 요청처리 -> Service
		Student loginStudent = new StudentService().login(student);
		// 성공 -> 스튜던트 객체 주소값 반환
		// 실패 -> null
		System.out.println(loginStudent);
		
		//System.out.println("studentId = " + studentId);
		//System.out.println("studentPwd = " + studentPwd);
		
		//System.out.println(studentId);
		//System.out.println(studentPwd);
		
		String idPattern = "^[a-z]{1,15}|[a-z0-9]{1,15}&";
		if(!Pattern.matches(idPattern, studentId)) {
			System.out.println("올바른 형식의 아이디가 아닙니다.");
		}
		
		String pwdPattern = "^(?:[a-z]{1,8}|\\d{1,8}|[a-z\\d]{1,8})$";
		if(!Pattern.matches(pwdPattern, studentPwd)) {
			System.out.println("올바른 형식의 비밀번호가 아닙니다.");
		}
		
		
		if(loginStudent != null) {
			// null 이 아니라면 로그인에 성공했다는 의미~!
			// 브라우저 종료시까지 로그인을 유지하기 위해 session scope에 담는다.
			
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginStudent);
			
			// RequestDispatcher get해오기
			request.getRequestDispatcher("/index.jsp")
			       .forward(request, response);
		} else {
			
			request.setAttribute("msg", "아이디와 비밀번호를 확인해주세요.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/result_page.jsp");
			view.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
