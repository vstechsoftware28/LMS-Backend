package com.lms.schoolRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.schoolEntity.ClassTeacher;

public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, Long>{
	Optional<ClassTeacher> findBySchoolNameAndStandardAndDivision(String schoolName, String standard, String division);

	List<ClassTeacher> findBySchoolNameAndApproved(String schoolName, boolean b);

	
}
