package com.lms.schoolRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.schoolEntity.Parent;

public interface ParentRepository extends JpaRepository<Parent,Long> {

	 List<Parent> findBySchoolNameAndChildStandardAndChildDivisionAndApprovedTrue(
		        String schoolName, String childStandard, String childDivision);

	List<Parent> findBySchoolNameAndChildStandardAndChildDivisionAndApprovedFalse(String schoolName, String standard,
			String division);
}
