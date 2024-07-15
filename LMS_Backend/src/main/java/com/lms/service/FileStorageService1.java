package com.lms.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService1 {
	@Value("${file.upload-dir1}") // Configure in application.properties
    private String uploadDir1;

    public String storeFile(MultipartFile file) throws IOException {
    	
        Path filePath = Paths.get(uploadDir1).resolve(file.getOriginalFilename()).toAbsolutePath();
        Files.copy(file.getInputStream(), filePath);
        return uploadDir1;
    }


}
