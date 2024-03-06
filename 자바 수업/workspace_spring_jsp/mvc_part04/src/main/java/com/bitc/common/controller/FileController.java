package com.bitc.common.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitc.common.util.FileUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FileController {
	
	private final String uploadPath;
	/**
	 *  프로젝트 root 경로 기준(webAppRoot)
	 *  해당되는 운영체제의 절대 경로를 읽기 위한 application context객체
	 */
	private final ServletContext context;
	
	private String realPath;
	
	@PostConstruct
	public void initPath() {
		realPath = context.getRealPath(File.separator+uploadPath);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
	
	@PostMapping("/uploadFile")
	public ResponseEntity<Object> uploadFile(MultipartFile[] file){
		ResponseEntity<Object> entity = null;
		try {
			List<String> list = new ArrayList<>();
			for(MultipartFile f : file) {
				String savedName = FileUtil.uploadFile(realPath, f);
				list.add(savedName);
			}
			entity = new ResponseEntity<>(list,HttpStatus.CREATED);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{
		return new ResponseEntity<>(
				FileUtil.getBytes(realPath, fileName),
				FileUtil.getHeaders(fileName),
				HttpStatus.OK);
	}
	
	// 파일 삭제 제거 요청
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName)throws Exception{
		boolean isDeleted = FileUtil.deleteFile(realPath, fileName);
		return new ResponseEntity<>(
						isDeleted ? "DELETED" : "FAILED",
						HttpStatus.OK);
	}
	
	// 요청 받은 전체 파일 삭제
	@PostMapping("/deleteAllfiles")
	public ResponseEntity<String> deleteAllFiles(
				@RequestParam("files[]") String[] files
			) throws Exception{
		boolean isDeleted = false;
		for(String file : files) {
			isDeleted = FileUtil.deleteFile(realPath, file);
		}
		return new ResponseEntity<>(isDeleted ?  "DELETED" : "FAILED", HttpStatus.OK);
	}
	
}










