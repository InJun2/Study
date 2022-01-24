<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home page</h1>
	
	<% 
		if(session.getAttribute("loginMember") != null){
		%>
			아이디 : ${loginMember.id} <br>
			닉네임 : ${loginMember.nick} <br>
			나이 : ${loginMember.age} <br>
			<a href="member/logout">로그아웃</a>	
		<%
		} else{
			%>
			<a href="member/login">로그인이 필요합니다</a>	
			<%
		}
	%>
	
	
</body>
</html>