<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>피자 가게</h1>
	
	<img src="imgs/menu.png">
	
	<form action="order" method="post">
		피자 :
		<select name="pizza">
			<option value="cheese">치즈피자</option>		
			<option value="combination">콤비네이션피자</option>
			<option value="potato">포테이토피자</option>		
		</select>
		<br>
		
		토핑 :
		<input type="checkbox" name="topping" value="sweetPatato"> 고구마무스
		<input type="checkbox" name="topping" value="cheese"> 치즈
		<input type="checkbox" name="topping" value="bite"> 치즈바이트
		<br>
		사이드 :
		<input type="checkbox" name="side" value="chicken"> 치킨
		<input type="checkbox" name="side" value="wing"> 윙
		<input type="checkbox" name="side" value="spa"> 스파게티
		<br>
		<input type="submit" value="주문">
	</form>

</body>
</html>