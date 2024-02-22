package com.bitc.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.file.vo.FileVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FileController {
	
	private final String uploadPath;
	private final String uploadDir;
	// application context
	private final ServletContext context;
	
	// 업로드할 디렉토리 경로를 저장할 필드
	private String realPath;
	
	
	@PostConstruct
	public void FileControllerInit() {
		// Controller Bean 생성이 되고 난후 의존성 주입까지 완료 되면
		// 서버 구동전 최초에 한번만 호출되는 method
		System.out.println("PostConstruct 호출 : " + uploadPath);
		File file = new File(uploadPath);
		if(!file.exists()) {
			// 디렉토리 생성
			file.mkdirs();
			System.out.println("디렉토리 생성완료");
		}
		// context.getRealPath("\\upload");
		realPath = context.getRealPath(File.separator+uploadDir);
		System.out.println(realPath);
		file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
			System.out.println("realPath upload 폴더 생성");
		}
		
		System.out.println("Controller 생성 및 사용준비 완료");
	}
	
	
	@GetMapping("/")
	public String home() {return "home";}
	
	@GetMapping("uploadForm")
	public void uploadForm() {}
	
	@GetMapping("uploadAjax")
	public void uploadAjax() {}
	
	@GetMapping("profile")
	public void profile() {}
	
	@PostMapping("uploadForm")
	public String uploadFor(
				MultipartFile file,
				Model model) throws Exception {
		System.out.println(file);
		if(!file.isEmpty()) {
			System.out.printf("File Name : %s %n", file.getOriginalFilename());
			System.out.printf("File size : %d %n", file.getSize());
			System.out.printf("File type : %s %n", file.getContentType());
			/*
			// File uploadDir = new File("c:\\Temp\\upload");
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
				System.out.println(uploadDir.getAbsolutePath()+" 생성 완료");
			}
			*/
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
	
	// 지정한 위치에 파일을 복제 업로드 후 업로드된 파일 이름 반환
	public String uploadFile(String original, byte[] fileData) throws IOException{
		String savedName = "";
		UUID uuid = UUID.randomUUID();
		// 총 32개의 랜덤한 문자 + 4개의 - 으로 조합된 36개의 문자
		savedName = uuid.toString().replace("-", "")+"_"+original;
		System.out.println(savedName);
		
		// Spring 에서 제공하는 파일 헬퍼 객체를 이용하여 지정된 위치에 파일 업로드
		FileCopyUtils.copy(fileData, new File(realPath,savedName));
		return savedName;
	}

	@PostMapping("uploadForm1")
	public String uploadForm1(
				// @RequestParam("file") MultipartFile[] files,
				@RequestParam("file") List<MultipartFile> files,
				Model model
			) throws Exception{
		List<String> saves = new ArrayList<>();
		for(MultipartFile f : files) {
			String savedName = uploadFile(f.getOriginalFilename(), f.getBytes());
			System.out.println(savedName);
			saves.add(savedName);
		}
		model.addAttribute("saves",saves);
		return "uploadResult";
	}
	
	
	@PostMapping("uploadForm2")
	public String uploadForm2(
				MultipartHttpServletRequest request,
				Model model) throws Exception{
		String auth = request.getParameter("auth");
		String content = request.getParameter("content");
		MultipartFile file = request.getFile("file");
		MultipartFile file1 = request.getFile("file1");
		String[] saves = new String[2];
		saves[0] = uploadFile(file.getOriginalFilename(), file.getBytes());
		saves[1] = uploadFile(file1.getOriginalFilename(), file1.getBytes());
		model.addAttribute("saves", saves);
		model.addAttribute("auth" , auth);
		model.addAttribute("content",content);
		return "uploadResult";
	}
	
	
	@PostMapping("uploadForm3")
	public String uploadForm3(
				String auth,
				String content,
				List<MultipartFile> files,
				MultipartFile file,
				FileVO vo,
				Model model
			)throws Exception{
		List<String> saves = new ArrayList<>();
		String savedName = uploadFile(file.getOriginalFilename(),file.getBytes());
		saves.add(savedName);
		for(MultipartFile f : files) {
			savedName = uploadFile(f.getOriginalFilename(),f.getBytes());
			saves.add(savedName);
		}
		model.addAttribute("saves", saves);
		model.addAttribute("auth",auth);
		model.addAttribute("content",content);
		System.out.println(vo);
		return "uploadResult";
	}
	
}




















