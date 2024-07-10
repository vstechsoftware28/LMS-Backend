package com.lms.schoolServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.schoolEntity.ClassTeacher;
import com.lms.schoolEntity.Parent;
import com.lms.schoolEntity.Student;
import com.lms.schoolRepository.ClassTeacherRepository;
import com.lms.schoolRepository.ParentRepository;
import com.lms.schoolRepository.StudentRepository;
import com.lms.schoolServiceIF.ClassTeacherServiceIF;
@Service
public class ClassTeacherServiceImpl implements ClassTeacherServiceIF{
	
	
	 @Autowired
	 private StudentRepository studentRepository;
	 
	@Autowired
	private ClassTeacherRepository classTeacherRepository;
	
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Override
	public ClassTeacher registerClassTeacher(ClassTeacher classTeacher) {
		Date date = new Date();
		classTeacher.setRegisDate(date);
		classTeacher.setUpdateDate(date);
		  classTeacher.setApproved(false);
		
		return classTeacherRepository.save(classTeacher);
	}

	

	    public void approveRegistration(Long classTeacherId, Long studentId) {
	        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));
	        Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

	        // Validate if class teacher matches the school, standard, and division of the student
	        if (!classTeacher.getSchoolName().equals(student.getSchoolName()) ||
	            !classTeacher.getStandard().equals(student.getStandard()) ||
	            !classTeacher.getDivision().equals(student.getDivision())) {
	            throw new IllegalArgumentException("Class teacher does not match the school, standard, and division of the student");
	        }

	        // Approve student registration
	        student.setApproved(true);
	        studentRepository.save(student);
	    }
	    
	    public List<Student> getUnapprovedStudents(Long classTeacherId) {
	        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));

	        return studentRepository.findBySchoolNameAndStandardAndDivisionAndApproved(
	                classTeacher.getSchoolName(),
	                classTeacher.getStandard(),
	                classTeacher.getDivision(),
	                false
	        );
	    }

	    public List<Student> getApprovedStudents(Long classTeacherId) {
	        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));

	        return studentRepository.findBySchoolNameAndStandardAndDivisionAndApproved(
	                classTeacher.getSchoolName(),
	                classTeacher.getStandard(),
	                classTeacher.getDivision(),
	                true
	        );
	    }
	    
	    public void approveParentRequest(Long classTeacherId, Long parentId) {
	        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));

	        Parent parent = parentRepository.findById(parentId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid parent ID"));

	        // Validate if class teacher matches the school, standard, and division of the child
	        if (!classTeacher.getSchoolName().equals(parent.getSchoolName()) ||
	            !classTeacher.getStandard().equals(parent.getChildStandard()) ||
	            !classTeacher.getDivision().equals(parent.getChildDivision())) {
	            throw new IllegalArgumentException("Class teacher does not match the school, standard, and division of the child");
	        }

	        // Perform approval logic
	        parent.setApproved(true); // Set parent's approval status to true
	        parentRepository.save(parent);
	    }
	    
	    
	    public List<Parent> getUnapprovedParents(Long classTeacherId) {
	        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));
	        System.out.println(classTeacher);
	        // Fetch unapproved parents associated with the class teacher
	        return parentRepository.findBySchoolNameAndChildStandardAndChildDivisionAndApprovedFalse(
	                classTeacher.getSchoolName(),
	                classTeacher.getStandard(),
	                classTeacher.getDivision()
	        );
	    }

	    public List<Parent> getApprovedParents(Long classTeacherId) {
	        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));

	        // Fetch approved parents associated with the class teacher
	        return parentRepository.findBySchoolNameAndChildStandardAndChildDivisionAndApprovedTrue(
	                classTeacher.getSchoolName(),
	                classTeacher.getStandard(),
	                classTeacher.getDivision()
	        );
	    }

}
