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
	<h1>미세먼지 조회 페이지</h1>
	
	<!-- xml로 정보 받아오기 : PublicDataApiController.java에서 produces부분 application/json -> text/xml로 변경 \n 
		"returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")) 에서 returntype json -> xml로 변경		-->
	<input type="text" id="numOfRows" placeholder="numOfRows">
	<button id="targetBtnXml">미세먼지 조회하기</button>
	
	<hr>
	
	<div id="targetDiv">
	</div>
	
	<script>
		$("#targetBtnXml").click(function(){
			let numOfRows = $("#numOfRows").val();
			$.ajax({
				url : "api-resp",
				data : {"numOfRows" : numOfRows},
				success : function(injundata){
					// jquery > find 함수 사용하기
					const itemArr = $(injundata).find('item');
					
					let $table = $('<table border="1" id="targetTable"></table>');
					let $thead = $('<thead></thead>');
					let $theadContent = $('<tr><th>districtName</th><th>issueDate</th><th>issueGbn</th><th>issueTime</th><th>moveName</th></tr>');
					let $tbody = $('<tbody></tbody>');
					
					$thead.append($theadContent);
					
					let tr = "";
					$(itemArr).each(function(i,item){
						tr 	= '<tr>'
							+ '<td>'+ $(item).find('districtName').text() +'</td>'
							+ '<td>'+ $(item).find('issueDate').text() +'</td>'
							+ '<td>'+ $(item).find('issueGbn').text() +'</td>'
							+ '<td>'+ $(item).find('issueTime').text() +'</td>'
							+ '<td>'+ $(item).find('moveName').text() +'</td>'
							+ '</tr>';
							
						$tbody.append(tr);
					})
					
					$table.append($thead, $tbody).appendTo($('#targetDiv'));
				},
				error : function(){
					alert("error");
				}
			})
		});
		
	</script>
</body>
</html>