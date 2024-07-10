package com.lms.schoolController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.schoolEntity.Student;
import com.lms.schoolServiceIF.StudentServiceIF;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
	private StudentServiceIF studentServiceIF;

	@PostMapping
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		Student createNewStudent = studentServiceIF.registerStudent(student);
		System.out.println(createNewStudent.getRegisDate());
		return new ResponseEntity<>(createNewStudent, HttpStatus.CREATED);
	}

	@GetMapping("/school/{schoolName}/class/{standard}/{division}")
	public ResponseEntity<List<Student>> getStudentsBySchoolAndClass(@PathVariable String schoolName,
			@PathVariable String standard, @PathVariable String division) {
		List<Student> students = studentServiceIF.getStudentsBySchoolAndClass(schoolName, standard, division);
		return ResponseEntity.ok(students);
	}

}
