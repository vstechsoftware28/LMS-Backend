package com.lms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lms.entity.TablSchool;
import com.lms.entity.TablSubject;
import com.lms.service.FileStorageService;
import com.lms.service.SchoolService;
import com.lms.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
    @Autowired
    private FileStorageService fileStorageService;
	
	@PostMapping("/addSubject")
    public ResponseEntity<String> addSubject(
            @RequestParam(value = "subjectCode", required = false) String subjectCode,
            @RequestParam("subjectName") String subjectName,
            @RequestParam("file") MultipartFile file, 
            @RequestParam(value = "teacherName", required = false) String teacherName,
            @RequestParam(value = "className", required = false) String className,
            @RequestParam(value = "division", required = false) char division,
            @RequestParam(value = "credit", required = false) int credit,
            @RequestParam(value = "description", required = false) String description) {

        try {
            

            // Create a new TablSubject instance
            TablSubject subject = new TablSubject();
            subject.setSubjectCode(subjectCode);
            subject.setSubjectName(subjectName);
            subject.setFile(file.getOriginalFilename()); // Save file name or other file details
            subject.setClassName(className);
            subject.setDivision(division);
            subject.setDescription(description);
            subject.setCredit(credit);
            subject.setTeacherName(teacherName);

            // Add the subject to the database
            TablSubject addedSubject = subjectService.addUser(subject,file);

            return ResponseEntity.status(HttpStatus.CREATED).body("Subject added successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add subject,Please give different filename, filename already exists");
        }

	}
	
	 @GetMapping("/viewSubject")
	    public ResponseEntity<List<TablSubject>> getAllSubjects() {
	        List<TablSubject> subjects = subjectService.getAllSubjects();
	        return ResponseEntity.ok(subjects);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<TablSubject> getSubjectById(@PathVariable Long id) {
	        Optional<TablSubject> subjectOptional = subjectService.getById(id);
	        if (subjectOptional.isPresent()) {
	            return ResponseEntity.ok(subjectOptional.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteSubject(@PathVariable Long id) {
	        try {
	            subjectService.deleteUser(id);
	            return ResponseEntity.ok("Subject with deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to delete subject with ID " + id);
	        }
	    }
	 
	 
	 
	 //Accept request
	 
	 @PutMapping("/{id}/acceptRequest")
	    public ResponseEntity<String> acceptRequestByTeacher(@PathVariable Long id) {
		 boolean updated = subjectService.acceptRequestByTeacher(id);
	        if (updated) {
	            return ResponseEntity.ok("Status updated successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update status");
	        }
	    }
	 
//  Retriving Student Data using StudentId,subjectName
	 
	 
	 @Autowired
	    public SubjectController(SubjectService subjectService) {
	        this.subjectService = subjectService;
	    }

//	    @GetMapping("/studentSubjectDetails")
//	    public ResponseEntity<List<Object[]>> getStudentSubjectDetails(@RequestParam("subjectName") String subjectName) {
//	        List<Object[]> studentSubjectDetails = subjectService.findStudentSubjectDetails(subjectName);
//	        return ResponseEntity.status(HttpStatus.OK).body(studentSubjectDetails);
//	    }
	 
}


    	
