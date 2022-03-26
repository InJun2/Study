<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set value="${pageContext.request.contextPath}" var="path"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<button class="btn btn-primary" onclick="location.href='${path}/member/A'">A</button>
	<button class="btn btn-primary" onclick="location.href='${path}/member/B'">B</button>
	<h3>사용자권한 : ${user.userAuthority}</h3>
	<a href="${path}/member/logout">로그아웃</a>
</body>
</html>