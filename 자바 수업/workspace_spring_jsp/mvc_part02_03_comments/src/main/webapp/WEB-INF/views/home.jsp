<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	#comments li {
		list-style:none;
		padding:10px;
		border:1px solid #ccc;
		height:150px;
		margin:5px 0;
	}
</style>
</head>
<body>
	<h2>AJAX - REST COMMENT TEST</h2>
	<h3>2번 게시글 댓글 정보</h3>
	<div>
		<div>
			comment author : <input type="text" id="cAuth"/>
		</div>
		<div>
			comment content : <input type="text" id="cText"/>
		</div>
		<button id="addBtn">ADD COMMENT</button>
	</div>
	<div>
		<!-- 댓글 목록 -->
		<ul id="comments"></ul>
	</div>
	
	
	
	<script>
		var bno = 2;	
		
		getCommentList();
		
		// 전체 댓글 목록 호출
		function getCommentList(){
			let url = "comment/"+bno+"/list";
			
			// type == get
			// dataType == json
			$.getJSON(url,function(data){
				console.log(data);
				printList(data);
			});
		} // 전체 댓글 목록 호출
		
		// 서버에서 전달 받은 댓글 목록을 페이지에 출력
		function printList(list){
			// #comments 에 li추가
			let str = "";
			// list[commentVO, commentVO...]
			for(var i = 0; i < list.length; i++){
				console.log("===========================");
				console.log(list[i].cno);
				console.log(list[i].author);
				console.log(list[i].content);
				console.log("===========================");
				str += `<li>
							\${list[i].cno} - \${list[i].author} - <button>MODIFY</button>
							<br/><hr/>
							\${list[i].content}
					   </li>`;
			}
			$("#comments").html(str);
			/*
			$(list).each(function(){
				console.log(this);
			});
			*/
		}
		
		
		// 댓글 삽입 요청 처리
		$("#addBtn").click(function(){
			
			let auth = $("#cAuth").val();
			let text = $("#cText").val();
			
			$.ajax({
				type : "post",
				url : "comment",
				data : {
					bno : bno,
					content : text,
					author : auth
				},
				dataType : "text",
				success : function(result){
					alert(result);
					$("#cAuth").val("");
					$("#cText").val("");
					getCommentList();
				},
				error : function(res){
					console.log(res);
					if(res.status === 400){
						alert("잘못된 데이터로 요청!!");
						alert(res.responseText);
					}else if(res.status === 404){
						alert("요청 경로를 확인하세요!");
					}
				}
			});
		});
	</script>
</body>
</html>




