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
		<h1>공지사항</h1>
	
		<table border="1" style="margin:auto;">
			<thead>
				<tr>
					<td><input type="checkbox"></td>
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성시간</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="#{list}" var="n">				
					<tr>
						<td><input type="checkbox" class="checkbox-del" value="${n.no}"></td>
						<td>${n.no}</td>
						<td>${n.title}</td>
						<td>${n.userNick}</td>
						<td>${n.enroll}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		
		<a href="${root}/notice/write">공지 작성</a>
		<button onclick="del();">삭제하기</button>
		
	</div>
	
	<script type="text/javascript">
		let topCheckBox = document.querySelector('thead input[type=checkbox]');
		
		let delArr = document.getElementsByClassName('checkbox-del');
		
		topCheckBox.onchange = function(e){
			// 맨 위의 체크박스가 체크될시 
			if(this.checked){
				for(let i=0; i< delArr.length; ++i){
					delArr[i].checked = true;
				}
			}else{
				for(let i=0; i< delArr.length; ++i){
					delArr[i].checked = false;
				}
			}
		}
	
		// 선택되어 있는 공지사항 삭제
		function del(){
			// 삭제할 번호들 가져오기
			let result="";
			// 삭제할 번호를 가져오기
			let delArr = document.getElementsByClassName('checkbox-del');
			
			for(let i=0; i<delArr.length; ++i){
				let t = delArr[i];
				if(t.checked){
					console.log(t.value);
					result += t.value + ',';					
				}
			}
			
			
			// 삭제 요청 보내기 ( 삭제할 번호들 전달해주면서 )
			$.ajax({
				url : "${root}/notice/delete",
				data : {"str" : result},
				type : 'post',
				success : function(data){
					console.log(data);
				},
				error : function(e){
					console.log(e);
				}
			});
			
			// 새로고침
			window.location.href="";
		}
	</script>
	
</body>
</html>