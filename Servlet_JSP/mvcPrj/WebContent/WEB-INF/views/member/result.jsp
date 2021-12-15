<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>id : <%=request.getAttribute("userId")%></h1>
	<h1>pwd : <%=request.getAttribute("userPwd")%></h1>
	<h1>name : <%=request.getAttribute("userName") %></h1>
	<h1>age : <%=request.getAttribute("userAge") %></h1>
	
	<h1>성인 여부 : <%=request.getAttribute("model")%></h1>
	
</body>
</html>