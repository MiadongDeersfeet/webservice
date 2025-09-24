<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	URI(Uniform Resource Identifier)
	식별자 - 고유한 이름(PK) -> 실제위치가 아니라 논리적인 식별값
	
	URL(Uniform Resource Locator)
	위치정보 -> 실제 파일의 경로나 웹 주소
 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자신과의 싸움</title>
</head>
<body>

	<h1>JSTL이란..?</h1>
	
	<p>
		Jakarta Server Page Standard Tag Library : JSP에 쓰는 표준 태그 라이브러리 <br>
		JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
		공통적으로 사용해야하는 코드들의 집합을 보다 쉽게 사용할 수 있도록 태그로 만들어서 <br>
		표준으로 제공하는 라이브러리(클래스 모음집)
	</p>
	
	<hr>
	
	<h3>* 라이브러리를 추가</h3>
	
	1) https://tomcat.apache.org로 접속 <br>
	2) Standard-1.2.5.jar파일 4개 모두 다운받기 <br>
	3) WEB-INF/lib폴더에 추가해주기 <br>
	
	<h4>* JSTL 선언</h4>
	
	<p>
		JSTL을 사용하고자 하는 해당 JSP파일 상단에 <br>
		(보통 page 지시어 바로 밑에) <br>
		taglib 지시어를 사용해서 선언함 <br>
		
		[ 표현법 ] <br>
		&lt;@ taglib prefix="접두어" uri="파일uri">
	</p>
	
	<hr>
	
	<h4>JSTL Core Library(오늘의 주인공)</h4>
	
	
	
	
</body>
</html>