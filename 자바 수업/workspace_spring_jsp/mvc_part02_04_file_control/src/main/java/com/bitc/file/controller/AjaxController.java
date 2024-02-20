package com.bitc.file.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitc.file.util.FileUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AjaxController {
	
	private final String uploadDir;
	private final  ServletContext context;
	
	private String realPath;
	
	@PostConstruct
	public void initPath() {
		realPath = context.getRealPath(File.separator+uploadDir);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}

	@PostMapping("uploadFiles")
	public ResponseEntity<List<String>> uploadFiles(
				List<MultipartFile> files
			) throws Exception{
		/*
		String datePath = FileUtil.calcPath(realPath);
		System.out.println(datePath);
		*/
		List<String> saves = new ArrayList<>();
		for(MultipartFile f : files) {
			// f.transferTo(new File(realPath));
			// FileCopyUtils.copy(f.getBytes(), new File(realPath,f.getOriginalFilename()));
			String fileName = FileUtil.uploadFile(realPath, f);
			saves.add(fileName);
		}
		System.out.println(saves);
		return new ResponseEntity<>(saves,HttpStatus.CREATED);
	}
	
}
















