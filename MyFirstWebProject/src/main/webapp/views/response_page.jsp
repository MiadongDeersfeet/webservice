<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 이 구문은 스크립틀릿(scriptlet)이라고 함
	// 자바코드를 그냥 쓸 수 있음
	// 보편적으로 이 곳에서는 request에 달려있는 Attribute를 뽑아내는 작업을 합니다. (왜냐하면 출력문보다 나중에 변수 선언하면 그 변수는 출력문에서 못쓰잖아~)
	// 현재 이 JSP상에서 필요한 데이터들을 => request의 Attribute에서 뽑아내기
	// request.getAttirbute("키값") : 뽑아내고 받아오는 건 Object일 수 밖에 없다.
	
	// ↓ 이게 왜 되죠? setAttribute 할 때 이미 age가 참조자료형으로 바뀌어서 들어감. ? 아마도
	int age = (int)request.getAttribute("age");
	double height = (double)request.getAttribute("height");
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	String city = (String)request.getAttribute("city");
	String[] foods = (String[])request.getAttribute("foods");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${ msg }</h1>
	
	<h3><%= name %>님의 정보~</h3>
	
	나이 : <%= age %> <br>
	키 : <%= height %> <br>
	지역 : <%= city %> <br>
	
	성별 :
	<!-- 성별을 선택하지 않았을 경우 -->
	<% if(gender == null) { %>
		선택안함쓰~~~<br>
	<% } else if("남".equals(gender)) {%>
	<!-- 성별을 선택했을 경우 -->
		남자쓰~~~~~<br>
	<% } else { %>
		여자쓰~~~~~<br>
	<% } %>
	
	좋아하는 음식쓰~~~~
	<!-- 선택을 했을 경우 -->
	<% if(foods == null) { %>
		안골라쓰~~~<br>
	<% } else { %>
		<ul>
		
		<% for(int i = 0; i < foods.length; i++) { %>
		<li><%= foods[i] %></li>
		<% } %>
		
		</ul>
		입니다.
		<% } %>
	<!--  선택을 안했을 경우 -->
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>