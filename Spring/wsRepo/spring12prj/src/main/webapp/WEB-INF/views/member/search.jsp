<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 검색 페이지</h1>
	<hr width="350" align="left">
	<form action="search" method="post">
		<select name="searchType">
			<option value="id">아이디</option>
			<option value="nick">닉네임</option>
			<option value="???">???</option>
		</select>
		<input type="text" name="searchValue">
		<input type="submit" value="검색">
	</form>
	<hr width="350" align="left">
	<br>
	
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>닉네임</td>
			<td>가입일</td>
		</tr>
		<c:forEach items="${list}" var="mvo">
			<tr>
				<td>${mvo.id}</td>
				<td>${mvo.nick}</td>
				<td>${mvo.enrollDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>