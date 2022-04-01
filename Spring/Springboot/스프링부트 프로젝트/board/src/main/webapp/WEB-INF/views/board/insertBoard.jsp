<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Board</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>

	<div class="container p-5 my-5">
		<h1>Board Insert</h1>
		
		<form action="${path}/board/insert" method="post">
			<div class="mb-3 mt-5">
				<label class="form-label">Title:</label>
				<input class="form-control" placeholder="Title" name="boardTitle">
			</div>
			<div class="mb-4 mt-3">
				<label>Content:</label>
				<textarea class="form-control" rows="5" placeholder="Content" name="boardContent" style="resize: none"></textarea>
			</div>
			
			<input type="submit" value="작성">
			<input type="button" value="취소" onclick="location.href='${path}/board/list'">
		</form>
	</div>
</body>
</html>