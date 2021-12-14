<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>index page</h1>
	
	<pre>
	ajax를 쓰는이유
		웹페이지 전체를 다시 로딩하지 않고도 웹 페이지의 일부분만을 갱신할 수 있음
	</pre>
	
	age : <input type="text" id="age">
	
	<button onclick="ajaxTest();">ajax test</button>
	
	<br><span id="isAdult"></span>
	
	<script>
		function ajaxTest(){
			// ajax는 JS로 사용가능하고, jQuery로 사용이 가능함
			
			// ajax
			$.ajax({
				url : "/ajax/myServlet",
				method : "Get",
				data : {
					name : "hwang",
					age : $("#age").val(),
					addr : "korea"
				},
				success : function(result){
					console.log("success : "+ result);
					$("#isAdult").text(result);
				},
				error : function(result){
					console.log("error : " + result);
				},
				complete : function(result){
					console.log("complete : " + result);
				}
			});
		}
	</script>
	
	
</body>
</html>