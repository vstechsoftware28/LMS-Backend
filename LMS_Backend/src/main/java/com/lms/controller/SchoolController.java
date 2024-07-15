package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.TablSchool;
import com.lms.service.SchoolService;



@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;
	
	//Add new user
	@PostMapping("/addSchoolRegistration")
	public ResponseEntity<String> addUser(@RequestBody TablSchool user) {
		
		 TablSchool addedStudent = schoolService.addUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Data added successfully");
		
	}
	

}
