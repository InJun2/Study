<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="/jdbc/member" method="post">
	아이디 : <input type="text" name="userId"> 
	<br>
	비번 : <input type="password" name="userPwd">
	<br>
	이름 : <input type="text" name="userName">
	<br><br>
	
	<input type="reset" value="초기화">
	<input type="submit" value="가입">
	</form>
	
</body>
</html>