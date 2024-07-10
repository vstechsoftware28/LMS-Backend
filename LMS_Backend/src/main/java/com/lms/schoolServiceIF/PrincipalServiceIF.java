package com.lms.schoolServiceIF;

import java.util.List;

import com.lms.schoolEntity.ClassTeacher;
import com.lms.schoolEntity.Principal;

public interface PrincipalServiceIF {
	Principal registerPrincipal(Principal principal);

	List<ClassTeacher> getUnapprovedClassTeachers(String schoolName);

	List<ClassTeacher> getApprovedClassTeachers(String schoolName);

	void approveClassTeacher(Long principalId, Long classTeacherId);
}
