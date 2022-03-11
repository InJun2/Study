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
	<form action="insert" method="post">
	<div class="input-group mb-3 input-group-lg">
		<input type="text" class="input-group-text form-control" name="name" placeholder="name">
		<input type="number" class="input-group-text form-control" name="age" placeholder="age">
		<input type="text" class="input-group-text form-control" name="home" placeholder="home">
	</div>
	<button>전송</button>
	</form>
</body>
</html>