<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>
	
	<div class="container p-5 my-5">
		<h1>Board List</h1>
		<button type="button" onclick="location.href='${path}/logout'" style="float: right">로그아웃</button>
		<br><br>
		<h4 style="text-align: right">user : ${user}</h4>
	
		<table class="table table-bordered projects">
	    	<thead>
	        	<tr>
	            	<th style="width: 2%">
	            		<input type="checkbox">
	                </th>
	                <th style="width: 15%" class="text-center">글번호</th>
	                <th style="width: 40%" class="text-center">제목</th>
	                <th style="width: 15%" class="text-center">작성자</th>
	               	<th style="width: 28%" class="text-center">작성일자</th>
	            </tr>
	      	</thead>
	        <tbody id="test">
		        <c:forEach items="${list}" var="l">		
					<tr>
						<td><input type="checkbox" class="checkbox-no" value="${l.boardNo}"></td>
						<td><a href="${path}/board/detail/${l.boardNo}">${l.boardNo}</a></td>
						<td>${l.boardTitle}</td>
						<td>${l.boardWriter}</td>
						<td class="text-center"><fmt:formatDate value="${l.boardDate}" pattern="yyyy. M. d."/></td>
					</tr>
				</c:forEach>
	        </tbody>
		</table>
		
		<button type="button" onclick="location.href='${path}/board/insert'">게시판등록</button>
		<button type="button" onclick="deleteBoard()">삭제</button>
	</div>


<script>
	function deleteBoard(){
		let checkArr = $(".checkbox-no");
		let result = "";
		for(let i=0; i<checkArr.length; i++){
			if(checkArr[i].checked){
				result += checkArr[i].value + ",";
			}
		}
		
		$.ajax({
			url : "${path}/board/delete/admin/"+result,
			type : "get",
			success: function(data){
				console.log("게시판 삭제 번호 전송 성공");
				
				let str= "";
					$.each(data, function(index, item){
						str	+= 
							"<tr>"+
								"<td><input type='checkbox' class='checkbox-no' value="+ item.boardNo +"></td>"+
								"<td><a href='${path}/board/detail/"+item.boardNo+"'>" + item.boardNo + "</a></td>"+
								"<td>"+ item.boardTitle+"</td>"+
								"<td>"+ item.boardWriter +"</td>"+
								"<td class='text-center'>"+ new Date(item.boardDate).toLocaleDateString(); +"</td>"+
							"</tr>";
					})
					
				$("#test").html(str);
			},
			error : function (e) {
				console.log(e);
			}  
		});
	}
</script>	
</body>
</html>