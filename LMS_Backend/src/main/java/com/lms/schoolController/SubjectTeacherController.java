package com.lms.schoolController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.schoolEntity.SubjectTeacher;
import com.lms.schoolServiceIF.SubjectTeacherServiceIF;

@RestController
@RequestMapping("/subjectTeacher")
public class SubjectTeacherController {

	@Autowired
	private SubjectTeacherServiceIF subjectTeacherServiceIF;

	@PostMapping
	public ResponseEntity<SubjectTeacher> registerSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		SubjectTeacher createSubjectTeacher = subjectTeacherServiceIF.registerSubjectTeacher(subjectTeacher);
		return new ResponseEntity<>(createSubjectTeacher, HttpStatus.CREATED);
	}
}
