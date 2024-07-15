package com.lms.repositary;

import com.lms.schoolEntity.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.entity.TablSubject;

public interface SubjectRepositary  extends JpaRepository<TablSubject, Long>{

//	   @Query("SELECT std.studentId, CONCAT(std.firstName, ' ', std.lastName) AS studentName, " +
//	           "std.division ,std.standard, ts.subjectName, ts.teacherName " +
//	           "FROM Student std JOIN TablSubject ts ON ts.studentId = std.studentId" +
//	           "WHERE ts.subjectName = :subjectName")
//	    List<Object[]> findStudentSubjectDetails(@Param("subjectName") String subjectName);

//	
//	@Query("SELECT std.studentId, CONCAT(std.firstName, ' ', std.lastName) AS studentName, " +
//		       "std.division, std.standard, ts.subjectName, ts.teacherName " +
//		       "FROM Student std JOIN std.tablSubjects ts  " +  // Assuming 'tablSubjects' is the attribute name in Student entity
//		       "WHERE ts.subjectName = :subjectName")
//		List<Object[]> findStudentSubjectDetails(@Param("subjectName") String subjectName);
}
