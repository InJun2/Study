<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<c:set value="${pageContext.request.contextPath}" var="path"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>B</h1>
	<p><a href="${path}/board/list">게시판</a></p>
	<a href="${path}/logout">로그아웃</a>
</body>
</html>