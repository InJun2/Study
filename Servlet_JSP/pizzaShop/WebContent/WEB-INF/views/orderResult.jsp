<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl파일  WebContent/WEB-INF/lib에 저장 후 위에 선언부 작성 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- c로 변경한 jstl 사용  -->
	<!-- JSTL > core >  -->
	<c:set var="myVar" value="myValue"/>
	
	<c:set target="${pizzaModel}" property="orderResult" value="changed result"/>
		
	<h1>${myVar}</h1>


	<h1>주문 결과 페이지 </h1>
	
	<!-- request.getAttribute("pizzaModel").getorderResult(); -->
	주문 성공 여부 : <span> ${pizzaModel.orderResult} </span>
	
	<h3>주문내역</h3>
	
	<br><br>
	피자 : <span> ${pizzaModel.pizza} </span><br>
	<c:forEach items="${pizzaModel.topping}" var="t">
		토핑 : <span> ${t} </span><br>
	</c:forEach>

	<c:forEach items="${pizzaModel.side}" var="s">
		사이드 : <span> ${s} </span><br>
	</c:forEach>
	
	<hr>
	
	<h1>${key01}</h1>
	<h1>${sessionKey}</h1>
	
	<!-- %{requestScope.testKey} -->
	<h1>${testKey}</h1>
	<h1>${sessionScope.testKey}</h1>
	<h1>${applicationScope.testKey}</h1>
	
	<hr><br>
	
	<!-- 사용가능한 el(Expression Language)연산자 찾아서 사용 -->
	<c:if test="${pizzaModel.pizza == 'combination'}">
		콩비네이션 피자가 맞습니다
	</c:if>
	
	
</body>
</html>