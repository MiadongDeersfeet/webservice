<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
<style>
	h1{
		color : red;
		font-size : 64px;
		text-align : center;
		height : 600px;
		line-height : 600px;
	}
</style>
</head>
<body>
	
	<jsp:include page="../include/header.jsp" /> 
	<!-- 워크 스페이스 경로 상에 보면 common 에서 하나 올라가서 include 로 들어가야하거든요? ../ 는 상위폴더 하나 위로 올라가겠다는 뜻 -->
	
	<h1>${ msg }</h1>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>