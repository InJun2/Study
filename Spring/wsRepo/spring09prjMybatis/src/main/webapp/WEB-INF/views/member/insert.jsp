<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member insert page</h1>
	
	<form action="insert" method="post">
		<!-- 메뉴 이름, 가격 -->
		아이디 : <input type="text" name="id"><br>
		비번 : <input type="password" name="pwd"><br>
		이름 : <input type="text" name="nick"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>