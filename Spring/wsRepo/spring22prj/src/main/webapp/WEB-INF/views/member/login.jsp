<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	
	<%-- 
	아이디 저장하기 
	--%>
	<c:choose>
		<%-- 쿠키가 없으면 로그인 화면 --%>
		<c:when test="${empty cookie.k01}">
			<form>
				<input type="text" name="id" placeholder="id">
				<br>
				아이디 기억하기 : <input type="checkbox">
			</form>
		</c:when>
		<%-- 쿠키가 있으면 아이디 넣기 --%>
		<c:otherwise>
			<form>
				<input type="text" name="id" placeholder="${cookie.k01.value}">
				<br>
				아이디 기억하기 : <input type="checkbox">
			</form>
		</c:otherwise>
	</c:choose>
	
</body>
</html>