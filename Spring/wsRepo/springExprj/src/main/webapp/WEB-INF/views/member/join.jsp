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
		<h1>회원 가입 페이지</h1>
		<form action="" method="post" enctype="multipart/form-data">
			아이디 : <input type="text" name="userId"><br>
			비밀번호 : <input type="password" name="userPwd"><br>
			닉네임 : <input type="text" name="userNick"><br>
			나이 : <input type="number" min="0" name="userAge"><br>
			성별 : 
			<select name="userGender">
				<option value="m">남자</option>
				<option value="f">여자</option>
			</select><br>
			사진 : <input type="file" name="f" multiple="multiple" accept=".jpg, .png"><br>
			<img id="profileImg" width="100px" height="100px">
			<input type="submit" value="회원가입">
		</form>
	</div>
		
	<script type="text/javascript">
		let fileTag = document.querySelector("input[name=f]");
		
		fileTag.onchange = function(){
			alert("파일 선택");
			
			// 파일있는지 확인
			if(fileTag.files.length > 0){
				// 미리보기 작업 실행
				let reader = new FileReader();
				reader.onload = function(data){
					console.log(data);
					let imgTag = document.querySelector("#profileImg");
					imgTag.src = data.target.result;
				}
				reader.readAsDataURL(fileTag.files[0]);
			}else{
				//
			}
		}
	</script>
		
</body>
</html>