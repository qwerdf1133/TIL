<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <h1>register.jsp</h1>
 <!--
 	action이 생략되면 연재 주소표시줄의 요청 경로로 요청 전달 
 	board/register 
-->
 <form id="registerForm" method="POST">
 	 <input type="hidden" name="uno" value="${userInfo.uno}"/>
	 <table>
	 	<tr>
	 		<td>제목</td>
	 		<td>
	 			<input type="text" name="title" required/>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>작성자</td>
	 		<td>
	 			<input type="text" name="writer" value="${userInfo.uname}" readonly/>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>내용</td>
	 		<td>
	 			<textarea name="content" cols="50" rows="20" required></textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<th colspan="2">
	 			<input type="button" id="saveBtn" value="게시글 등록"/>
	 		</th>
	 	</tr>
	 </table>
	 <!-- Drag & Drop file upload -->
	 <div>
	 	<label>FILE DROP HERE</label>
	 	<div class="fileDrop"></div>
	 	<div>
	 		<ul class="uploadList">
	 		
	 		</ul>
	 	</div>
	 </div>	
 </form>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <script>
 	// drag & drop 시 브라우저가 파일을 해석 할려는 기본이벤트를 제거
 	$(".fileDrop").on("dragenter dragover",function(e){
 		e.preventDefault();
 	});
 
 	$(".fileDrop").on("drop",function(e){
 		e.preventDefault();
 		
 		let files = e.originalEvent.dataTransfer.files;
 		// console.log(files);
 		let maxSize = 10485760; // 10MB
 		
 		let formData = new FormData();
 		for(let i = 0; i < files.length; i++){
 			if(files[i].size > maxSize){
 				alert("업로드 할 수 없는 파일이 포함되어있습니다.");
 				return false;
 			}
 			formData.append("file", files[i]);
 		}
 		
 		$.ajax({
 			type : "POST",
 			url : "${path}/uploadFile",
 			data : formData,
 			contentType : false,
 			processData : false,
 			dataType : "json",
 			success : function(data){
 				// upload 된 파일 이름을 list(배열) 로 전달
 				// console.log(data);
 				for(let i = 0; i < data.length; i++){
 					console.log(data[i]);
 					let fileInfo = getFileInfo(data[i]);
 					console.log(fileInfo);
 					let html = "<li>";
 					html += "<img src='"+fileInfo.imgSrc+"'/>";
 					html += "<div>";
 					html += "<a href='"+fileInfo.getLink+"' target='_blank'>";
 					html += fileInfo.fileName;
 					html += "</a>";
 					html += "</div>";
 					html += "<div>";
 					// fullName == data[i]
 					html += "<a href='"+data[i]+"' class='delBtn'>[삭제]</a>";
 					html += "</div>";
 					html += "</li>";
 					$(".uploadList").append(html);
 				}
 			},
 			error : function(res){
 				alert(res.responseText);
 			}
 		});
 	});
 
 	// image file 확인
 	function checkImage(fileName){
 		return fileName.indexOf("s_") > 0 ? true : false;
 	}
 	
	var contextPath = '${path}';
 	
 	// li 로 출력에 필요한 파일 정보를 반환할 함수
 	function getFileInfo(fullName){
 		// 이미지 경로, 원본 파일 이름, 원본파일 요청 경로
 		let imgSrc,    fileName,     getLink;
 		// /contextPath/displayFile?fileName=업로드된 파일 이름
 		if(checkImage(fullName)){
 			// 이미지 파일 - s_db59c759c27941ab985b40b92cdbbeba_camera.png
 			imgSrc = contextPath+"/displayFile?fileName="+fullName;
 			// 원본 이미지 링크 - db59c759c27941ab985b40b92cdbbeba_camera.png
 			getLink = contextPath+"/displayFile?fileName="+fullName.replace("s_","");
 		}else{
 			// 일반 파일경우 출력 이미지는 file.png
 			imgSrc = contextPath+"/resources/img/file.png";
 			getLink = contextPath+"/displayFile?fileName="+fullName;
 		}
 		// db59c759c27941ab985b40b92cdbbeba_camera.png
 		// 업로드한 파일 이름
 		fileName = fullName.substr(fullName.lastIndexOf("_")+1);
 		// fileName = camera.png
 		return {fileName : fileName, imgSrc : imgSrc, getLink : getLink};
 	}
 	
 	// 첨부파일 삭제
 	$(".uploadList").on("click",".delBtn",function(event){
 		event.preventDefault(); // a tag 기본 이벤트 처리 제거
 		// .delBtn인 요소들 중에 click event가 발생한 대상 요소
 		let target = $(this);
 		// target .delBtn의 href 속성에 부여된 값 == fullName
 		let fullName = target.attr("href");
 		$.ajax({
 			type : "POST",
 			url : contextPath+"/deleteFile",
 			data : {
 				fileName : fullName
 			},
 			success : function(data){
 				alert(data);
 				// closest target 기준으로 부모요소 중에
 				// 선택자로 지정된 가장 가까운 부모요소를 검색
 				target.closest("li").remove();
 			}
 		});
 	});
 	
 	// 게시글 등록 버튼이 click 되면
 	$("#saveBtn").click(function(){
 		let str = "";
 		let fileList = $(".uploadList .delBtn");
 		console.log(fileList);
 		for(let i = 0; i < fileList.length; i++){
 			str += "<input type='hidden' name='files' value='"+fileList[i].getAttribute("href")+"' />";
 		}
 		$("#registerForm").append(str);
 		$("#registerForm").submit();
 	});
 </script>
 <div style="clear: both;"></div>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 