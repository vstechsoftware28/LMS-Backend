package com.lms.schoolController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.schoolEntity.ClassTeacher;
import com.lms.schoolEntity.Principal;
import com.lms.schoolServiceIF.PrincipalServiceIF;

@RestController
@RequestMapping("/principal")
public class PrincipalController {

	@Autowired
	private PrincipalServiceIF principalServiceIF;

	@PostMapping
	public ResponseEntity<Principal> registerPrincipal(@RequestBody Principal principal) {
		Principal createPrinciple = principalServiceIF.registerPrincipal(principal);
		return new ResponseEntity<>(createPrinciple, HttpStatus.CREATED);
	}

	@PostMapping("/{principalId}/approve-class-teacher/{classTeacherId}")
	public ResponseEntity<String> approveClassTeacher(@PathVariable Long principalId,
			@PathVariable Long classTeacherId) {
		try {
			principalServiceIF.approveClassTeacher(principalId, classTeacherId);
			return ResponseEntity.ok("Class teacher registration approved.");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{schoolName}/unapproved-class-teachers")
	public ResponseEntity<List<ClassTeacher>> getUnapprovedClassTeachers(@PathVariable String schoolName) {
		List<ClassTeacher> unapprovedClassTeachers = principalServiceIF.getUnapprovedClassTeachers(schoolName);
		return ResponseEntity.ok(unapprovedClassTeachers);
	}

	@GetMapping("/{schoolName}/approved-class-teachers")
	public ResponseEntity<List<ClassTeacher>> getApprovedClassTeachers(@PathVariable String schoolName) {
		List<ClassTeacher> approvedClassTeachers = principalServiceIF.getApprovedClassTeachers(schoolName);
		return ResponseEntity.ok(approvedClassTeachers);
	}
}
