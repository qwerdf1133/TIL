package com.bitc.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@GetMapping("/")
	public String home() {return "home";}
	
	@GetMapping("uploadForm")
	public void uploadForm() {}
	
	@PostMapping("uploadForm")
	public String uploadFor(
				MultipartFile file,
				Model model) throws Exception {
		System.out.println(file);
		if(!file.isEmpty()) {
			System.out.printf("File Name : %s %n", file.getOriginalFilename());
			System.out.printf("File size : %d %n", file.getSize());
			System.out.printf("File type : %s %n", file.getContentType());
			
			File uploadDir = new File("c:\\Temp\\upload");
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
				System.out.println(uploadDir.getAbsolutePath()+" 생성 완료");
			}
			// 업로드 시킬 파일 위치 경로
			// File uploadFile = new File(uploadDir, file.getOriginalFilename());
			// upload된 파일의 정보를 저장하고 있는 객체 MultipartFile
			// file.transferTo(uploadFile);
			byte[] bytes = file.getBytes();
			String savedName = uploadFile(file.getOriginalFilename(), bytes);
			model.addAttribute("savedName",savedName);
			/*
			FileOutputStream fos = new FileOutputStream(uploadFile);
			fos.write(bytes);
			fos.flush();
			fos.close();
			*/
		}else {
			System.out.println("upload 한 파일이 존재 하지 않음.");
		}
		return "uploadResult";
	}
	
	
	public String uploadFile(String original, byte[] fileData) throws IOException{
		String savedName = "";
		UUID uuid = UUID.randomUUID();
		// 총 32개의 랜덤한 문자 + 4개의 - 으로 조합된 36개의 문자
		savedName = uuid.toString().replace("-", "")+"_"+original;
		System.out.println(savedName);
		
		// Spring 에서 제공하는 파일 헬퍼 객체를 이용하여 지정된 위치에 파일 업로드
		FileCopyUtils.copy(fileData, new File("C:\\Temp\\upload",savedName));
		return savedName;
	}

}


















