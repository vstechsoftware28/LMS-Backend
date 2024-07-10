package com.lms.schoolServiceIF;

import java.util.List;

import com.lms.schoolEntity.Student;

public interface StudentServiceIF {
	Student	registerStudent(Student student);
	public List<Student> getStudentsBySchoolAndClass(String schoolName, String standard, String division);
	
}
