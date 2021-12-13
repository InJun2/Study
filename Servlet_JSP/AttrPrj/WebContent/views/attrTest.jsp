<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp page</h1>
	
	<%
		String id_param = request.getParameter("id");
		String id_attr = String.valueOf(request.getAttribute("id"));
		// getAtrribute는 반환타입이 오브젝트 타입임
	%>
	
	<span>파라미터로 가져온 아이디 : <%=id_param %></span>
	<span>attr로 가져온 아이디 : <%=id_attr %></span>
</body>
</html>