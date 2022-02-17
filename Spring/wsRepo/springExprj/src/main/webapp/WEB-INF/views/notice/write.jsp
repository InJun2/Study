<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div id="div-main">
		<h1>공지사항 작성하기</h1>
		
		<form action="" method="post" onsubmit="return writeCheck();">
			제목 : <input type="text" name="title"><br>
			작성자 : <input type="text" value="${loginUser.userNick}" readonly><br>
			<input type="hidden" name="writer" value="${loginUser.userNo}">
			내용 : <textarea rows="30" cols="50" name="content"></textarea><br>
			<input type="submit" value="공지사항 작성">
		</form>
		
	</div>
	
	<script type="text/javascript">
		function writeCheck(){
			return confirm("작성하시겠습니까?");
		}
	</script>
	
</body>
</html>