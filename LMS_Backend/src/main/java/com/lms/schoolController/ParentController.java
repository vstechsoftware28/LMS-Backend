package com.lms.schoolController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.schoolEntity.Parent;

import com.lms.schoolServiceIF.ParentServiceIF;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	private ParentServiceIF parentServiceIF;

	@PostMapping
	public ResponseEntity<Parent> registerParent(@RequestBody Parent parent) {
		Parent createParent = parentServiceIF.registerParent(parent);
		return new ResponseEntity<>(parent, HttpStatus.CREATED);
	}

}
