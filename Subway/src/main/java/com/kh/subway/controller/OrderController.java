package com.kh.subway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.do") // <= 얘 먼저 요로코롬 바꿔주자~!
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0) 요청전송방식이 뭐지?
		// GET / POST => 우리는 겟방식이니까 지금은 넘어갈게요~!
		
		// 1) 요청 시 전달값이 있는가?
		// => 값 뽑기
		// => request.getParameter("키값")
		// => request.getParameterValues("키값")
		
		// 값을 뽑아서 변수에 대입
		// 주문자정보
		String name = request.getParameter("userName");
		// 주문정보
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
