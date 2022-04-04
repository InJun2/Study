<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>
	
	<div class="container p-5 my-5">
		<h1>Board List</h1>
		<button type="button" onclick="location.href='${path}/logout'" style="float: right">로그아웃</button>
		<br><br>
		<h4 style="text-align: right">user : ${user}</h4>
	
		<table class="table table-bordered projects">
	    	<thead>
	        	<tr>

	                <th style="width: 15%" class="text-center">글번호</th>
	                <th style="width: 40%" class="text-center">제목</th>
	                <th style="width: 15%" class="text-center">작성자</th>
	               	<th style="width: 30%" class="text-center">작성일자</th>
	            </tr>
	      	</thead>
	        <tbody>
		        <c:forEach items="${list}" var="l">		
					<tr>
						<td><a href="${path}/board/detail/${l.boardNo}">${l.boardNo}</a></td>
						<td>${l.boardTitle}</td>
						<td>${l.boardWriter}</td>
						<td class="text-center"><fmt:formatDate value="${l.boardDate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
	        </tbody>
		</table>
		
		<button type="button" onclick="location.href='${path}/board/insert'">게시판등록</button>
	</div>

</body>
</html>