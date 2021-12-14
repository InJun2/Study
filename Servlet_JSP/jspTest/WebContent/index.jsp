<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 에러 발생시 해당 패스로 이동 -->
<%@ page errorPage="views/error/errorResult.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="views/common/header.jsp" %>

	<h1>index.jsp page</h1>
	
	<% 
		// 예외 발생
		int x = 1/0;
	%>
	
	<!-- JSP는 JASPER가 JAVA파일로 바꿔줌 -->
	<!-- 
		주석 (html, java, jsp)
		지시자 (앞에 @ 붙이면 됨)
		선언문 (앞에 ! 붙이면 됨)
		스크립트릿 (자바코드영역)
		표현식 (
	-->
	
	 
	<%
		// 자바코드 주석
		/**/
	%>

	<%-- 
		jsp 주석		
	--%>
	
	<%
		System.out.println("syso");
		int num1 = 10;
		int num2 = 20;
	%>
	
	<span>num 값은 : <%=num1+num2%></span>
	
	<%myMethod(); %>
	
	<%!
	public void myMethod(){
		System.out.println("myMethod called");
	}
	%>

	<%@ include file="views/common/footer.jsp" %>
</body>
</html>