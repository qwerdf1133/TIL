<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadAjax.jsp</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.fileDrop{
		width:100%;
		height:200px;
		background-color:#ccc;
		border:1px solid black;
	}
</style>
</head>
<body>
	<h2>File drag &amp; drop</h2>
	
	<!-- upload할 파일을 drop할 박스 -->
	<div class="fileDrop"></div>
	
	<!-- upload 된 파일 목록 출력 -->
	<div id="uploadedList"></div>
	
	
	<script>
		// drag drop 이벤트 시 파일을 인식 할려는 브라우저의 기본 이벤트 무시
		$(".fileDrop").on("dragenter dragover", function(e){
			// 발생한 이벤트 객체를 매개변수로 전달
			e.preventDefault(); // event 객체의 기본 이벤트 무시
		});
		
		$(".fileDrop").on("drop",function(e){
			e.preventDefault();
			
			// 발생 한 drag drop 이벤트 객체에서 사용자가 드랍한 파일 정보를 읽어옴
			let files = e.originalEvent.dataTransfer.files;
			console.log(files);
			
			let formData = new FormData();
			for(let i = 0; i < files.length; i++){
				let file = files[i];
				let maxSize = 10485760; // 10MB
				if(maxSize < file.size){
					alert("업로드 할 수 없는 크기의 파일입니다.");
					return false;
				}
				formData.append("files",file);
			}
			
			$.ajax({
				type : "POST",
				url : "uploadFiles",
				data : formData,
				contentType : false,
				processData : false,
				dataType : "json",
				success : function(result){
					console.log(result);
					let str = "";
					for(let i = 0; i < result.length; i++){
						if(checkImageType(result[i])){
							console.log("이미지 파일");
							str += "<div>";
							str += "<img src='${path}/upload"+result[i]+"' />";
							str += "</div>";
							str += "<a href=''>";
							str += getOriginalName(result[i]);
							str += "</a>";
						}else{
							console.log("일반 파일");
							str += "<div>";
							str += "<img src='${path}/resources/img/file.png' />";
							str += "</div>";
							str += "<a href=''>";
							str += getOriginalName(result[i]);
							str += "</a>";
						}
					} // end for
					$("#uploadedList").append(str);
				}// end success
			}); // end ajax
		}); // end drop event
		// 2024/02/20/00a669c05823448995e3bdfb16946a3b_평가주의사항.pptx
		function getOriginalName(fileName){
			let index = fileName.lastIndexOf("_") + 1;
			// 평가주의사항.pptx
			return fileName.substr(index);
		}
		
		// upload된 파일이 이미지 파일인지 확인
		function checkImageType(fileName){
			let pattern= /jpg|jpeg|gif|png/i;
			let result = pattern.test(fileName);
			console.log(result);
			// return result;
			let img = ['jpg','jpeg','png','gif'];
			for(let i = 0; i < img.length; i++){
				if(fileName.toLowerCase().endsWith(img[i])){
					return true;
				}
			}
			return false;
		}
		
	</script>
</body>
</html>














