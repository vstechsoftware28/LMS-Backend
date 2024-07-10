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
import com.lms.schoolEntity.Parent;
import com.lms.schoolEntity.Student;
import com.lms.schoolServiceIF.ClassTeacherServiceIF;

@RestController
@RequestMapping("/classTeacher")
public class ClassTeacherController {

	@Autowired
	private ClassTeacherServiceIF classTeacherServiceIF;

	@PostMapping
	public ResponseEntity<ClassTeacher> registerClassTeacher(@RequestBody ClassTeacher classTeacher) {
		System.out.println("inside the post method");
		ClassTeacher createClassTeacher = classTeacherServiceIF.registerClassTeacher(classTeacher);
		return new ResponseEntity<>(createClassTeacher, HttpStatus.CREATED);
	}

	@PostMapping("/{classTeacherId}/approve-registration/{studentId}")
	public ResponseEntity<String> approveRegistration(@PathVariable Long classTeacherId, @PathVariable Long studentId) {
		try {
			classTeacherServiceIF.approveRegistration(classTeacherId, studentId);
			return ResponseEntity.ok("Student registration approved.");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{classTeacherId}/unapproved-students")
	public ResponseEntity<List<Student>> getUnapprovedStudents(@PathVariable Long classTeacherId) {
		try {
			List<Student> unapprovedStudents = classTeacherServiceIF.getUnapprovedStudents(classTeacherId);
			return ResponseEntity.ok(unapprovedStudents);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{classTeacherId}/approved-students")
	public ResponseEntity<List<Student>> getApprovedStudents(@PathVariable Long classTeacherId) {
		try {
			List<Student> approvedStudents = classTeacherServiceIF.getApprovedStudents(classTeacherId);
			return ResponseEntity.ok(approvedStudents);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{classTeacherId}/approve-parent/{parentId}")
	public ResponseEntity<String> approveParentRequest(@PathVariable Long classTeacherId, @PathVariable Long parentId) {
		try {
			classTeacherServiceIF.approveParentRequest(classTeacherId, parentId);
			return ResponseEntity.ok("Parent request approved successfully");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{classTeacherId}/unapproved-parents")
	public ResponseEntity<List<Parent>> getUnapprovedParents(@PathVariable Long classTeacherId) {
		try {
			System.out.println(classTeacherId);
			List<Parent> unapprovedParents = classTeacherServiceIF.getUnapprovedParents(classTeacherId);
			return ResponseEntity.ok(unapprovedParents);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(null); // Handle exception appropriately
		}
	}

	// Endpoint to fetch approved parents for a specific class teacher
	@GetMapping("/{classTeacherId}/approved-parents")
	public ResponseEntity<List<Parent>> getApprovedParents(@PathVariable Long classTeacherId) {
		try {
			List<Parent> approvedParents = classTeacherServiceIF.getApprovedParents(classTeacherId);
			return ResponseEntity.ok(approvedParents);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(null); // Handle exception appropriately
		}
	}

}
