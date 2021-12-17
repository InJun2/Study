<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원조회</h1>
	
	<form action="memberCheck" method="post">
		조회할 회원 아이디 : <input type="text" name="userId">
		<br>
		<input type="submit" value="조회">
	</form>
</body>
</html>