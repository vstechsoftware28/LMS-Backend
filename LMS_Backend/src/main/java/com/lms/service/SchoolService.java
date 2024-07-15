package com.lms.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.TablSchool;
import com.lms.repositary.SchoolRepositary;
@Service
public class SchoolService {
	@Autowired
	private SchoolRepositary schoolRepo;
	
	public TablSchool addUser(TablSchool user) {
		user.setRegistrationDate(LocalDate.now()); // Set current date/time
        user.setCreatedAt(new Date()); // Set current date/time
		return schoolRepo.save(user);
	}

}
