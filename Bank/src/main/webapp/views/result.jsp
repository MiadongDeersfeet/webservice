<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <!--  얘네는 페이지 지시어라고 하는데 이 친구의 속성으로 import를 할 수 있어요. -->
<%@ page import="com.kh.bank.model.vo.Bank"%> <!--  그런데 여기에 page 지시어를 하나 더 두고 import를 따로 분리해주는 게 일반적입니다. -->
<% 
	// 스크립틀릿 : 자바코드를 그대로 작성하는 영역(세미콜론을 포함한 형태)
	// JSP는 Servlet으로 변환되어 동작하기 때문에 클래스 작성과 동일한 방식을 생각해야한다.
	
	Bank customer = (Bank)request.getAttribute("customer"); // set할 때 스트링 타입으로 넘겼던 키값, order 로 넘겼으니까 order 를 적어줘야해요. // 캐스팅 연산자로 강제형변환!
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌신규확인 페이지</title>
<style>
	#wrap{
		width: 1200px;
		margin: auto;
	}
	
	h1{
		text-align : center;
	}
</style>
</head>
<body>
	<div id="wrap"> 
		<h1>신청내역</h1>
		<%--  오더의 필드값에 넣어놓은 값을 가져다가 출력하고 싶은데!!!!!!??????--%>
		<%--
			JSP 주석
			
			JSP내용들은 여기다 주석 처리
			
			출력식 : <%= %> 이 안에다가 출력하고 싶은 자바 변수라던가 메소드(?)라던가 넣어주는 거죠.ㅣ
			※※※ 출력식에는 세미콜론을 달지 않습니다. // 스크립틀릿에는 무조건 달아야하지만~
		 --%>
		
		<h3>신규고객정보</h3>
	
		이름 : <%= customer.getName() %><br>
		주민번호 : <%= customer.getId() %><br>
		전화번호 : <%= customer.getPhone() %><br>
		이메일 : <%= customer.getEmail() %><br>
		주소 : <%= customer.getAddress() %><br><br>
		예금종류 : <%= customer.getType() %><br><br>
	
		
		위와 같이 신규하시겠습니까? <br><br>
		
		<button>확인</button><button>취소</button>
	

	</div>
</body>
</html>