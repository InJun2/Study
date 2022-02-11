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
	
	<input type="text" id="numOfRows" placeholder="numOfRows">
	<button id="targetBtn">미세먼지 조회하기</button>
	
	<hr>
	
	<div id="targetDiv">
	</div>
	
	<!--  
	<table id="targetTable" border="1">
		<thead>
			<tr>
				<th>districtName</th>
				<th>issueDate</th>
				<th>issueGbn</th>
				<th>issueTime</th>
				<th>moveName</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	-->
	<script>
		$("#targetBtn").click(function(){
		let numOfRows = $("#numOfRows").val();
			$.ajax({
				url : "api-resp",
				data : {"numOfRows" : numOfRows},
				success : function(injundata){
					alert("success");
					
					const itemArr = injundata.response.body.items;
					
					// 테이블 만들기
					let $table = $('<table border="1" id="targetTable"></table>');
					let $thead = $('<thead></thead>');
					let $theadContent = $('<tr><th>districtName</th><th>issueDate</th><th>issueGbn</th><th>issueTime</th><th>moveName</th></tr>');
					let $tbody = $('<tbody></tbody>');

					
					$thead.append($theadContent);
					
					// 반복문을 돌며, 우리가 원하는 데이터 얻기
					let tr=""
					$(itemArr).each(function(i, item){
						tr 	= '<tr>'
							+ '<td>' + item.districtName + '</td>'
							+ '<td>' + item.issueDate + '</td>'
							+ '<td>' + item.issueGbn + '</td>'
							+ '<td>' + item.issueTime + '</td>'
							+ '<td>' + item.moveName + '</td>'
							+'</tr>';
							
						$tbody.append(tr);
					});
					
					// 테이블 내부와 반복문 안에서 얻은 데이터들을 테이블에 넣기
					//let x = $table.append($thead, $tbody);
					$table.append($thead, $tbody).appendTo($("#targetDiv"));
					
					
					/*
					let tbodyContent = "";
					$(itemArr).each(function(i, item){
						tbodyContent 	+= 	'<tr>'
							+	'<td>' + item.districtName + '</td>'
							+	'<td>' + item.issueDate + '</td>'
							+	'<td>' + item.issueGbn + '</td>'
							+	'<td>' + item.issueTime + '</td>'
							+	'<td>' + item.moveName + '</td>'
							+  	'</tr>'
					});
					$("#targetTable tbody").html(tbodyContent); 
					*/
					
					// 동적으로 요소 만들어서 처리
					
					
					/* 
					const itemArr = injundata.response.body.items;
					let tbodyContent = "";
					
					for(let i in itemArr){
						let item = itemArr[i];
						
						item.districtName;
						item.issueDate;
						item.issueGbn;
						item.issueTime;
						item.moveName;
						
						tbodyContent 	+= 	'<tr>'
										+	'<td>' + item.districtName + '</td>'
										+	'<td>' + item.issueDate + '</td>'
										+	'<td>' + item.issueGbn + '</td>'
										+	'<td>' + item.issueTime + '</td>'
										+	'<td>' + item.moveName + '</td>'
										+  	'</tr>'
					}
					
					$("#targetTable tbody").html(tbodyContent); 
					*/
					
				},
				error : function(){
					alert("error");
				}
			})
		});
	</script>
</body>
</html>