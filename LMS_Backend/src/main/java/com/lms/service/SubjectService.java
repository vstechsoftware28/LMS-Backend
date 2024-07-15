package com.lms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lms.entity.TablSubject;
import com.lms.repositary.SubjectRepositary;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {
	@Autowired
    private SubjectRepositary subjectRepo;

    @Autowired
    private FileStorageService fileStorageService;
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Transactional
    public TablSubject addUser(TablSubject user, MultipartFile file) throws IOException {
    
            // Handle file upload
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = fileStorageService.uploadFile(file);
                String filePath = uploadDir + File.separator + fileName;
                user.setCreatedAt(new Date());
                user.setUpdatedAt(new Date());
                user.setStatus(false);
                user.setFile(fileName); // Set the file name or identifier in the entity
            } catch (Exception e) {
                // Handle file storage exception here
                e.printStackTrace();
                throw new IOException("Failed to store file " + file.getOriginalFilename(), e);
            }
        }
       
      
        
        TablSubject savedUser = subjectRepo.save(user);
        return savedUser; // Save the entity with the file information
    }
    	
    
    	
    public List<TablSubject> getAllSubjects() {
        return subjectRepo.findAll();
    }
    
    public Optional<TablSubject> getById(Long id) {
        return subjectRepo.findById(id);
    }
    
    public void deleteUser(Long id) {
        subjectRepo.deleteById(id);
    }
    
    
    //subject request accept method
    public boolean acceptRequestByTeacher(Long id) {
        TablSubject subject = subjectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found "));

        // Perform logic to accept request
        subject.setStatus(true);

        subjectRepo.save(subject);
		return true;
    }
    


    @Autowired
    public SubjectService(SubjectRepositary subjectRepo) {
        this.subjectRepo = subjectRepo;
    }
//
//    public List<Object[]> findStudentSubjectDetails(String subjectName) {
//        return subjectRepo.findStudentSubjectDetails(subjectName);
//    }

}
