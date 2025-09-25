package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

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
		
		//System.out.println(userId);
		//System.out.println(userPwd);
		
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		// 그러면 이제 뭐 해야할까요?
		// 3. 요청처리 (Service에게)
		Member loginMember = new MemberService().login(member);
		// 성공했을 경우 : 조회성공한 컬럼값을 필드에 담은 멤버객체 주소값
		// 실패했을 경우 : null값
		
		// 모범시민 답게 성공/실패 시를 모두 테스트 해봐야겠죠?
		// System.out.println(loginMember);
		
		// 4. 응답화면 지정
		// 스텝 1. request 속성에 출력할 값 추가 => setAttribute()
		// 스텝 2. RequestDispatcher => 뷰 지정
		// 스텝 3. RequestDispatcher 이용해서 forward() 호출
		
		// 1. 로그인된 사용자의 정보를 어딘가에 담을 것(application, session, request, page)
		
		/*
		 * 크다
		 * 1) application : 웹 애플리케이션 전역에서 사용 가능
		 * 					(일반 자바 클래스에서 값을 사용할 수 있음)
		 * 
		 * 2) session : 모든 JSP와 Servlet에서 꺼내 쓸 수 있음
		 * 				단, session에 값이 지워지기 전까지
		 *              세션 종료 시점 : 브라우저 종료, 서버 멈춤, 코드로 지움
		 * 
		 * 3) request : 해당 request를 포워딩한 응답 JSP에서만 쓸 수 있음
		 *              요청부터 응답까지만 딱 쓸 수 있음
		 *              
		 * 4) page : 값을 담은 JSP에서만 쓸 수 있음              
		 * 작다
		 * 
		 * => 일반적으로 session, request를 많이 사용함
		 */
		
		// 로그인에 성공할 수도 있음 / 실패할 수도 있음
		// 2. 성공실패 여부에 따라서 응답 페이지 다르게
		
		if(loginMember != null) {
		    // 로그인에 성공했다!! == 조회해온 loginMember가 null이 아니라면 조회가 된 거죠~!
			
			// 사용자의 정보를 앞단에 넘기기
			// 로그인한 회원의 정보를 로그아웃 하거나
			// 브라우저를 종료하기 전까지는 계속해서 유지하고 사용할 것이기 때문에
			// session scope에 담을 것입니다.
			
			// 스텝 1. session의 Attribute로 사용자 정보 추가
			// session의 타입 : HttpSession
			// => 현재 요청 보내는 Client의 Session : request.getSession();
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember); // 담았다~~~~
			
			// 스텝 2. RequestDispatcher get해오기 (성공 시 웰컴파일 다시 보여주고 싶음)
			request.getRequestDispatcher("/index.jsp")
			       .forward(request, response);
			
		} else {
		
		// 실패했따! 로 가정해봅시다. => 실패용 페이지를 만듭시다. msg 라는 키값으로 로그인 안됐어요...하는 밸류를 보낼 겁니다. 포워딩 할 겁니다.
		request.setAttribute("msg", "아이디와 비밀번호를 확인해주세요."); // 스텝 1
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/result_page.jsp");
		view.forward(request, response);
		
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
