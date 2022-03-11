<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<table class="table table-bordered table-hover">
	<tr>
		<th>이름</th> 
		<th>나이</th>
		<th>주소</th>
	</tr>
	<c:forEach items="#{dto}" var="d">
		<tr>
			<td>${d.name}</td>
			<td>${d.age}</td>
			<td>${d.home}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>