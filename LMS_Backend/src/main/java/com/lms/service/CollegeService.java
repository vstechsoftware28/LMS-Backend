package com.lms.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.TablCollege;
import com.lms.repositary.CollegeRepositary;



@Service
public class CollegeService {
	
		@Autowired
		private CollegeRepositary collegeRepo;
		
		public TablCollege addUser(TablCollege user) {
			user.setRegistrationDate(LocalDate.now()); // Set current date/time
	        user.setCreatedAt(new Date()); // Set current date/time
			return collegeRepo.save(user);
		}

}
