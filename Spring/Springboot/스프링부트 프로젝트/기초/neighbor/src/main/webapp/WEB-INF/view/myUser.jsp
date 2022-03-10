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
	<c:forEach items="#{dto}" var="d">
		<h2>${d.name}</h2>
		<h2>${d.age}</h2>
		<h2>${d.home}</h2>
		<br><br>
	</c:forEach>
</body>
</html>