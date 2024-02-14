<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript.jsp</title>
</head>
<body>
	<h1>자바 스크립트</h1>
	<input type="button" id="continue_btn" value="CONTINUE"/>
	<div id="box1"></div>
	<hr/>
	<div id="box2"></div>
	
	<script>
		/*
			AJAX란 비동기 자바스크립트와XML(Asynchronous Javascript And Xml) 의 약어로
			비동기 형식으로 브라우저의 요청 변경없이 javascript와 서버 간의 통신을 하기 위한
			XMLHttpRequest 객체를 사용하는 것을 말한다.
		*/
		// XMLHttpRequest을 저장하기 위한 변수
		var httpRequest;
		
		// click 이벤트 처리 추가
		document.getElementById("continue_btn").onclick = function(){
			// continue_btn 이 click 되었을 때 실행될 callback 함수
			// alert("click");
			httpRequest = new XMLHttpRequest();
			if(!httpRequest){
				alert("AJAX 통신 불가");
				return false;
			}
			
			// XMLHttpRequest 생성 완료
			
			// 요청 처리 단계에 따라 결과를 처리할 함수 지정
			httpRequest.onreadystatechange = setContents;
			
			//open(전송방식,요청URL,비동기&동기 여부)
			// 비동기&동기 : true - 비동기,  false - 동기 
			httpRequest.open('GET','sample2?name=최기근&age=27',false);
			// 등록된 정보로 server에 요청
			httpRequest.send();
			
			console.log("send 호출 완료");
		};
		
		// 요청 처리 단계별 상태에 따른 처리를 할 함수
		function setContents(){
			// 요청 처리에 따른 현재 상태
			console.log(httpRequest.readyState);
			/*
				0(uninitialized) - (request가 초기화 되지 않음) 
				1(loading)		 - (서버와 연결이 성사됨)
				2(loaded)		 - (서버가 request를 받음)
				3(interactive)	 - (request(요청)을 처리하는 중)
				4(complate)		 - (request에 대한 처리가 끝났으며 응답받은 데이터를 사용할 준비가 완료됨)
			*/
			
			if(httpRequest.readyState === 4){
				// 응답 완료
				// 응답 상태 코드
				console.log(httpRequest.status);
				if(httpRequest.status === 200){
					
					let str = httpRequest.responseText;
					console.log(str);
					document.getElementById("box1").innerHTML = str;
					
					// JSON 형식으로 작성된 문자열을 Javascript Object로 변환
					let obj = JSON.parse(str);
					console.log(obj);
					
					// obj에 저장된 데이터를 출력할 테이블 태그
					let html = "<table border='1'>";
					html += "<tr><th>이름</th><th>나이</th></tr>";
					html += "<tr><td>"+obj.name+"</td><td>"+obj.age+"</td></tr>";
					html += `<tr><td>\${obj.name}</td><td>\${obj.age}</td></tr>`;
					html+="</table>";
					console.log(html);
					
					document.getElementById("box2").innerHTML = html;
					
					/*
					// 자바스크립트 객체 출력 테스트
					let testObj = {n : "a", m : 12};
					console.log(testObj);
					*/
				}else{
					alert("요청 처리를 완료하지 못했습니다.");
				}
			}
		}
	
	</script>
</body>
</html>