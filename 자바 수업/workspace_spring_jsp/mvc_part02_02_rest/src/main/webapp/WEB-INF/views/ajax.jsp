<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX with jQuery</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div style="background-color:#ccc; height:900px;"></div>
	<div>
		<input type="text" id="name" autofocus /> <br/>
		<input type="number" id="age" />  <br/>
		<button id="submit">get submit</button> <br/>
		<button id="post">post submit</button> <br/>
		<button id="put">put submit</button> <br/>
	</div>
	<div id="result" style="border:1px solid black; padding:10px; margin-top:10px;"></div>
	<div style="height:500px;"></div>
	
	<script>
		$("#submit").click(function(){
			// click 이벤트가 발생하면 실행 될 callback 함수
			// alert("실행");
			let input_name = $("#name").val();
			let input_age = $("#age").val();
			
			// ajax() - 매개변수로 ajax 통신 요청과 결과를 처리하기 위한 설정 값을
			//          javascript 객체로 전달
			let obj = {
				type : 'GET',				// 전송 방식
				async : true,				// 비동기 , 동기 제어
				url : "sample2",			// 요청 URL, 요청 경로
				data : {					// 전달 파라미터
					name : input_name,
					age : input_age
				},
				// 응답으로 전달 받은 responseText를 어떤 타입으로 사용할 건지 지정
				dataType : "json",			// text, json, xml
				// 응답이 정상적으로 완료 되었을 때 실행 될 함수
				success : function(data, statusText, response){
					console.log("data : ", data);
					console.log("statusText : " , statusText);	
					console.log("response : " , response);
					
					let html = "<table border='1'>";
					html += "<tr><th>이름</th><th>나이</th></tr>";
					html += `<tr><td>\${data.name}</td><td>\${data.age}</td></tr>`;
					html += "</table>";
					console.log(html);
					$("#result").html(html);
				},
				error : function(response, status){
					console.log("error response : ", response);
					console.log("처리 상태 : " , status);
					console.log("error message : " , response.responseText);
				}
			}; // obj end
			
			$.ajax(obj);
			
		}); // get submit ajax event end
		
		$("#post").click(function(){
			
			let input_name = $("#name").val();
			let input_age = $("#age").val();
			
			$.ajax({
				
				type : "POST",
				url : "sampleList",
				data : {
					name : input_name,
					age : input_age
				},
				dataType : "json",
				success : function(data){
					console.log(data);
					let result = `<table border=1>
									<tr>
										<th>이름</th>
										<th>나이</th>
									</tr>`;
					for(var i = 0; i < data.length; i++){
						result += `<tr>
									<td>\${data[i].name}</td>
									<td>\${data[i].age}</td>
								   </tr>`;
					}				
					result += `</table>`;
					console.log(result);
					$("#result").append(result);
				},
				error : function(res){
					alert(res.responseText);
				}
			});
		}); // post ajax event end
		// (GET, POST) - PUT, PATCH, DELETE
		$("#put").click(function(){
			$.ajax({
				type : "PUT",
				url : "sampleList",
				dataType : "json",
				headers : {
					/* application/x-www-form-urlencoded */
					'Content-Type' : 'application/json'
				},
				// JSON.parse(문자열) : JSON 형식으로 작성 된 문자열을 javascript Object로 변환
				// JSON.stringify(Jscript Object)javascript Object를 JSON 형식의 문자열로 변환
				data : JSON.stringify({name : $("#name").val(),age : $("#age").val()}),
				success : function(data){
					console.log(data);
				},
				error : function(res){
					alert(res.responseText);
					console.log(res);
				}
			});
		});
		
	</script>
</body>
</html>
