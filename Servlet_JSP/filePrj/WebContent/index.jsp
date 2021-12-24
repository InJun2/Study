<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 테스트</h1>
	
	<form action="fileTest" method="post" enctype="multipart/form-data">
		<input type="text" name="id"><br>
		<input type="file" name="f"><br>
		<input type="file" name="f"><br>
		<input type="file" name="f"><br>
		<input type="submit" value="제출">
	</form>
	
	<hr><hr>
	
	<img src= "upload/${path}" alt="none">
	<a href = "upload/${path}" download>이미지 다운로드</a>
</body>
</html>