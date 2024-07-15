package com.lms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lms.entity.TablRecordedVideo;
import com.lms.entity.TablSubject;
import com.lms.service.FileStorageService1;
import com.lms.service.RecordedVideoService;

@RestController
@RequestMapping("/recordedVideo")
public class RecordedVideoController {
	@Autowired
    private RecordedVideoService recordedVideoService;

    @Autowired
    private FileStorageService1 fileStorageService;

    @Value("${file.upload-dir1}") // Injected from application.properties
    private String uploadDir1;


    @PostMapping("/addVideo")
    public ResponseEntity<String> uploadFile(
            @RequestParam("videoFile") MultipartFile videoFile,
            @RequestParam("file") MultipartFile file,
            @RequestParam("topic") String topic,
            @RequestParam("subTopic") String subTopic,
            @RequestParam("description") String description) {
        try {
        	if (videoFile.isEmpty() || file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please select both video file and file to upload.");
            }
            String videoFileName = fileStorageService.storeFile(videoFile);
            String fileFileName = fileStorageService.storeFile(file);

            TablRecordedVideo recordedVideo = new TablRecordedVideo();
            recordedVideo.setUploadVideo(videoFileName);
            recordedVideo.setNotes(fileFileName);
            recordedVideo.setTopic(topic);
            recordedVideo.setSubTopic(subTopic);
            recordedVideo.setDescription(description);

            TablRecordedVideo savedVideo = recordedVideoService.addRecord(recordedVideo);
            String successMessage = "Data added successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
        } catch (IOException ex) {
        	ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + ex.getMessage());
        
       }
    }
    @GetMapping("/viewAll")
    public List<TablRecordedVideo> getAllRecordedVideos() {
		return recordedVideoService.getAllRecordedVideos();
    	
    }
    
    @GetMapping("/{id}")
    public Optional<TablRecordedVideo> getRecordedVideoById(@PathVariable Long id) {
		return recordedVideoService.getRecordedVideoById(id);
    }
    
    

}
