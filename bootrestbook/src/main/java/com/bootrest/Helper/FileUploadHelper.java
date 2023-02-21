package com.bootrest.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//public final String UPLOAD_DIR= "E:\\Spring boot class\\Book\\bootrestbook\\src\\main\\resources\\static\\image";
	
	
	public boolean uploadFile(MultipartFile multiPartFile) {
		boolean f= false;
		try {
			final String UPLOAD_DIR= new ClassPathResource("static/image").getFile().getAbsolutePath();
		//InputStream is= multiPartFile.getInputStream();
		//byte[] data= new byte[is.available()];
		//is.read(data);
	//	
		//FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+ File.separator + multiPartFile.getOriginalFilename());
		//fos.write(data);
		//fos.flush();
	//	fos.close();
		
		Files.copy(multiPartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename()),
				StandardCopyOption.REPLACE_EXISTING);
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
     
}
