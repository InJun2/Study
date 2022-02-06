<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ad page</h1>
	
	<%-- 광고 출력, 쿠키가 있다면 미출력 --%>
	<c:if test="${empty cookie.k01}">
		<script>
			window.open("https://www.naver.com", "test", "width=300, height=300");
		</script>
	</c:if>
</body>
</html>