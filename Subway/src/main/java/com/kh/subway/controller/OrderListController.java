package com.kh.subway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/orderList.sandwich")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 서블릿이 버전업을 했을 때 이력관리를 해야해요. 그럼 1L 라고 되어있는 곳에 숫자를 하나씩 올려줘야해요~~(우리가 안만지게찌...?)
       
    public OrderListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청전송방식
		// GET? POST?
		// a태그 요청 == 100% GET방식
		
		// 요청 시 전달값이 있는가?
		// => 값 뽑기
		// => request.getParameter("키값")			
		// => request.getParameterValues("키값")
		
		// 1) 데이터 가공 => X (전달값이 없어서 패쓰)
		
		// 2) 요청처리 -> Service단 호출
		// SELECT문이니까 ResultSet이 돌아올 것이고
		// 하나의 정보는 하나의 VO이고
		// VO가 몇 개인지 알 수 없음 -> 0개일수도 100개일수도 ... => LIST를 써서 SUBWAY라는 VO를 담아올 거예요.
		List<Subway> orderList = new SubwayService().findAll();
		
		//System.out.println(orderList);
		request.setAttribute("orders", orderList);
		
		request.getRequestDispatcher("/views/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
