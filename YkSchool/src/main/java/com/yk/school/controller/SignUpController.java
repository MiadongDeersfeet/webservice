package com.yk.school.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yk.school.model.service.StudentService;
import com.yk.school.model.vo.Student;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("WEB-INF/views/include/signUp.jsp").forward(request, response);
		
		String studentId = request.getParameter("studentId");
		String studentPwd = request.getParameter("studentPwd");
		String studentName = request.getParameter("studentName");
		String phone = request.getParameter("phone");
		String lang = request.getParameter("lang");
		
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setStudentPwd(studentPwd);
		student.setStudentName(studentName);
		student.setPhone(phone);
		student.setLang(lang);
		
		int result = new StudentService().signUp(student);
		
		if(result > 0) {
			System.out.println("시원하네~~~");
			request.setAttribute("student", student);
			
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			
			view.forward(request, response);
			
		} else {
			System.out.println("그러니까 복습좀 잘하라고~~~");
			request.setAttribute("msg", "회원가입에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/signUp_fail.jsp");
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
