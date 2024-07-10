package com.lms.schoolServiceIF;

import java.util.List;

import com.lms.schoolEntity.ClassTeacher;
import com.lms.schoolEntity.Parent;
import com.lms.schoolEntity.Student;


public interface ClassTeacherServiceIF {
	ClassTeacher registerClassTeacher(ClassTeacher classTeacher);
	 public void approveRegistration(Long classTeacherId, Long studentId);
	 public List<Student> getApprovedStudents(Long classTeacherId);
	 public List<Student> getUnapprovedStudents(Long classTeacherId);
	 public List<Parent> getApprovedParents(Long classTeacherId);
	 public List<Parent> getUnapprovedParents(Long classTeacherId);
	 public void approveParentRequest(Long classTeacherId, Long parentId);
}
