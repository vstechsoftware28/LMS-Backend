package com.lms.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.lms.entity.TablRecordedVideo;
import com.lms.entity.TablSchool;
import com.lms.repositary.RecordedVideoRepositary;

@Service
public class RecordedVideoService {
	@Autowired
	private RecordedVideoRepositary recordedVideoRepositary;
	
	public TablRecordedVideo addRecord(TablRecordedVideo user) {
		user.setCredtedAt(new Date()); // Set current date/time
        user.setUpdatedAt(new Date()); // Set current date/time
		return recordedVideoRepositary.save(user);
	}
	
	public List<TablRecordedVideo> getAllRecordedVideos() {
		return recordedVideoRepositary.findAll();
		
		
	}
	
	
	 public Optional<TablRecordedVideo> getRecordedVideoById(Long id) {
		 
		return recordedVideoRepositary.findById(id);
		 
	 }
	 
}


