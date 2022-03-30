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
	<div class="container p-5 my-5 border">
		<h1>login</h1>
		
		<form action="${path}/login" method="post">
		  <div class="mb-3 mt-3">
		    <label class="form-label">Id:</label>
		    <input type="text" class="form-control" name="userId" placeholder="Enter id">
		  </div>
		  <div class="mb-3">
		    <label for="pwd" class="form-label">Password:</label>
		    <input type="password" class="form-control" placeholder="Enter password" name="userPwd">
		  </div>
		  <a href="${path}/join" style="float:right" class="mb-2"><b>Join</b></a>
		  <button type="submit" class="form-control btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>