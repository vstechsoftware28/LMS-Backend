package com.lms.schoolServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.schoolEntity.Student;
import com.lms.schoolRepository.StudentRepository;
import com.lms.schoolServiceIF.StudentServiceIF;


@Service
public class StudentServiceImpl implements StudentServiceIF{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student registerStudent(Student student) {
		// TODO Auto-generated method stub
		Date date = new Date();
		student.setRegisDate(date);
		student.setUpdateDate(date);
		System.out.println(student.getRegisDate());
		System.out.println(student.getUpdateDate());
		  student.setApproved(false);
		  if (student.getStudentId() == null || student.getStudentId().isEmpty()) {
	            student.setStudentId(generateStudentId());
	        }
		return studentRepository.save(student);
	}
	  private String generateStudentId() {
	        // Fetch the last student ID from the database
	        Long lastStudentId = studentRepository.findMaxStudentId();
	        System.out.println(lastStudentId);
	        // Determine the next student ID
	        if (lastStudentId == null) {
	            // If no students exist yet, start from LSM00001
	            return "LSM00001";
	        } else {
	            // Extract the numeric part and increment
	            String lastIdStr = String.valueOf(lastStudentId);
	            String numericPart = lastIdStr.substring(3); // Assuming the format is LSM00001
	            int nextNumericValue = Integer.parseInt(numericPart) + 1;
	            System.out.println(nextNumericValue);
	            // Format the next student ID
	            return "LSM" + String.format("%05d", nextNumericValue);
	        }


	    }


	 public List<Student> getStudentsBySchoolAndClass(String schoolName, String standard, String division) {
	        return studentRepository.findBySchoolNameAndStandardAndDivision(schoolName, standard, division);
	    }
}
