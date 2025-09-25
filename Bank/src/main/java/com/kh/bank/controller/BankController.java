package com.kh.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.bank.model.service.BankService;
import com.kh.bank.model.vo.Bank;

@WebServlet("/openacc.do")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0) 여기는 GET 방식~!
		
		// 값 뽑기 
		String name  = request.getParameter("Name");
	    String id    = request.getParameter("Id");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		String address = request.getParameter("Address");
		String type = request.getParameter("Type");
		
		// 가공을 해야게찌?
		Bank customer = new Bank();
		customer.setName(name);
		customer.setId(id);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setType(type);
		
		//System.out.println(customer);
		
		int result = new BankService().openAcc(customer);
		
		if(result > 0) {
			
			 request.setAttribute("customer", customer);
			 RequestDispatcher view = request.getRequestDispatcher("/views/result.jsp");
			 view.forward(request, response);
		}  else {
			   response.getWriter().append("fail :'( ");
		   }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
