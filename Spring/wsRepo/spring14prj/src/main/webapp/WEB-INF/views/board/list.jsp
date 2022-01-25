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
	<h1>게시글 목록 페이지</h1>
	<p>전체 글 개수 : ${list.size()}</p>
	
	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>내용</td>
				<td>작성자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="l">			
				<tr>
					<td><a href="detail/${l.title}">${l.title}</a></td>
					<td>${l.content}</td>
					<td>${l.writer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>