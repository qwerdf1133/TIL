<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<form action="uploadFoem" method="POST" enctype="multipart/form-data">
	<div>
		<img src="resources/img/profile.jpg" id="sampleImage" width="100"/>
		<br/>
		<input type="file" name="file" id="profileImage" accept=".gif, .jpg, .jpeg, .png"/>
		<button>전송</button>
	</div>
	<script>
		$("#profileImage").on("change", function(){
			let files = this.files;
			console.log(files);
			
			let file = files[0];
			// 사용자 컴퓨터에서 사용자가 선택한 파일이 저장된 실제 위치 정보를
			// HTML 문서가 해석할수 있는 URL 경로로 반환
			let path = window.URL.createObjectURL(file);
			console.log(path);
			$("#sampleImage").attr("src", path);
		});
	</script>
</form>
</body>
</html>









