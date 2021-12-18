<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문 결과 페이지 </h1>
	
	<!-- request.getAttribute("pizzaModel").getOrderResult(); -->
	주문 성공 여부 : <span> ${pizzaModel.orderResult} </span>
	
	<h3>주문내역</h3>
	
	<br><br>
	피자 : <span> ${pizzaModel.pizza} </span><br>
	토핑 : <span> ${pizzaModel.topping} </span><br>
	사이드 : <span> ${pizzaModel.side} </span><br>
	
</body>
</html>