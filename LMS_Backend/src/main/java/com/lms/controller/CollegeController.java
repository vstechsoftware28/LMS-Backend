package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.TablCollege;
import com.lms.service.CollegeService;
@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	private CollegeService collegeService;
	
	//Add new user
	@PostMapping("/addCollegeRegistration")
	public ResponseEntity<String> addUser(@RequestBody TablCollege user) {
		
		 TablCollege addedStudent = collegeService.addUser(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Data added successfully");
		
	}

}
