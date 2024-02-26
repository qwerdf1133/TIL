<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	#messageList{
		margin-left:0;
	}
	
	#messageList li{
		list-style:none;
		border:1px solid black;
		padding:5px;
		height:80px;
		margin-bottom:5px;
	}
	
	#messageList li:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<input type="text" id="targetid" placeholder="수신자아이디"/> <br/>
	<input type="text" id="sender" placeholder="발신자아이디"/> <br/>
	<textarea id="message" placeholder="전달할 메세지"></textarea> <br/>
	<button id="add">SEND MESSAGE</button>
	
	<ul id="messageList">
		
	</ul>
	
	<script>
		getMessageList();	
	
		function getMessageList(){
			$.getJSON("messages/list",function(result){
				console.log(result);
				let str = "";
				for(let i = 0; i < result.length; i++){
					let msg = result[i];
					console.log(msg);
					let senddate = getDate(msg.senddate);
					console.log(senddate);
					let opendate = '';
					if(msg.opendate != null ){
						opendate = getDate(msg.opendate);
					}else{
						opendate = "미확인";
					}
					console.log(opendate);
					str += `<li onclick='readMessage(\${msg.mno}, "\${msg.targetid}", this)'>`;
					str += `\${msg.mno} | 수신자 : \${msg.targetid} | 발신자 : \${msg.sender} <br/>`;
					str += `\${msg.message} <br/> 수신확인 :  \${opendate} | 발신시간 : \${senddate}`;
					str += `</li>`;
				}
				$("#messageList").html(str);
			});		
		}
		
		// 수신 요청 처리 함수
		function readMessage(mno, uid, element){
			console.log(mno, uid, element);
			$.ajax({
				type : "PATCH",
				url : "messages/read/"+mno+"/"+uid,
				dataType : "JSON",
				success : function(msg){
					// msg == 수신확인된 MessageVO 정보
					let str = `\${msg.mno} | 수신자 : \${msg.targetid} | 발신자 : \${msg.sender} <br/>`;
					str += `\${msg.message} <br/> 수신확인 :  \${getDate(msg.opendate)} | 발신시간 : \${getDate(msg.senddate)}`;
					$(element).html(str);
				},
				error : function(res){
					alert(res.responseText);
				}
			});
		}
		
		function getDate(date){
			// new Date();  현재시간
			// new Date(time); 매개변수로 전달된 시간 
			let dateTime = new Date(date);
			let dateStr = dateTime.getFullYear()+"년 ";
			dateStr += (dateTime.getMonth()+1) +"월 ";
			dateStr += dateTime.getDate()+"일 ";
			dateStr += dateTime.getHours()+"시 ";
			dateStr += dateTime.getMinutes()+"분 ";
			dateStr += dateTime.getSeconds()+"초 ";
			return dateStr;
		}
		
		// message 정보 추가
		$("#add").click(function(){
			$.ajax({
				type : "POST",
				url : "messages/add",
				data : {
					targetid : $("#targetid").val(),
					sender : $("#sender").val(),
					message : $("#message").val()
				},
				dataType : "text",
				success : function(result){
					alert(result);
					$("#targetid").val("");
					$("#sender").val("");
					$("#message").val("");
					$("#targetid").focus();
					getMessageList();
				},
				error : function(res){
					alert("error");
					alert(res.responseText);
				}
			});
		});
	
	</script>
</body>
</html>













