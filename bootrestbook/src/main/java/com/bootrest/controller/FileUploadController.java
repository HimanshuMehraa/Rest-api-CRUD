package com.bootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootrest.Helper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
	//	System.out.println(file.getOriginalFilename());
	//	System.out.println(file.getSize());
	//	System.out.println(file.getName());
	//	System.out.println(file.getContentType());
		try {
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File must contain image");
		}
		
		if(!(file.getContentType().equals("image/png"))) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("png only");
		}
		  boolean f=fileUploadHelper.uploadFile(file);
		  if(f) {
			  return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
					  .path(file.getOriginalFilename()).toUriString());
		  }
		//FILE UPLOAD CODE 
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
