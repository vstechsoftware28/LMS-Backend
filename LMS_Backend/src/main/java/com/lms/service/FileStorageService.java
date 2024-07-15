package com.lms.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileStorageService {

	    @Value("${file.upload-dir}")
	    private String uploadDir;

	    public String uploadFile(MultipartFile file) throws IOException {
	        try {
	            Path uploadPath = Paths.get(uploadDir);
	            Files.createDirectories(uploadPath);

	            Path filePath = uploadPath.resolve(file.getOriginalFilename());
	            Files.copy(file.getInputStream(), filePath);
	        } catch (IOException e) {
	            throw new IOException("Could not store file " + file.getOriginalFilename() + ". Please try again!", e);
	        }
			return uploadDir;
	    }
}
