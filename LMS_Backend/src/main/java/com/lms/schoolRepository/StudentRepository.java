package com.lms.schoolRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.schoolEntity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query("SELECT MAX(CAST(SUBSTRING(s.studentId, 4) AS integer)) FROM Student s")
    Long findMaxStudentId();
	List<Student> findBySchoolNameAndStandardAndDivision(String schoolName, String standard, String division);

	List<Student> findBySchoolNameAndStandardAndDivisionAndApproved(String schoolName, String standard, String division,
			boolean b);
	
}
