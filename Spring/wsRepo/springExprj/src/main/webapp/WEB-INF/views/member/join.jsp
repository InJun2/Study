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
			사진 : <input type="file" name="f" multiple="multiple" accept=".jpg, .png" onchange="preview()"><br>
			<div id="div-preview">
			
			</div>
			<input type="submit" value="회원가입">
		</form>
		
	</div>
		
	<script type="text/javascript">
		function preview(){
			// 파일 여러개 미리보기	
			let fileTag = document.querySelector('input[name=f]');
			let divTag = document.querySelector('#div-preview');
			
			if(fileTag.files.length >0){
				// 파일을 올렸을 때
				
				// 이미지 src에 들어갈 데이터 구하기
				for(let i=0; i<fileTag.files.length; ++i){
					let reader = new FileReader();
					reader.onload = function(data){				
						// 이미지 태그 만들어서 넣기
						
						// 1. 이미지 태그 만들기
						let imgTag = document.createElement('img');
						
						// 2. 이미지 태그 속성들 셋팅하기
						imgTag.setAttribute('src', data.target.result);
						imgTag.setAttribute('width', '100');
						imgTag.setAttribute('height', '100');
						
						// 3. 이미지 태그 집어넣기
						divTag.appendChild(imgTag);
					}
					// 읽기 실행
					reader.readAsDataURL(fileTag.files[i]);
				}
				
			}else {
				// 취소 버튼을 눌렀을 때
				divTag.innerHTML= "";
				
			}		
		}
		
	</script>
		
</body>
</html>