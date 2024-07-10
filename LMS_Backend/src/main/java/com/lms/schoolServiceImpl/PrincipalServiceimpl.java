package com.lms.schoolServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.schoolEntity.ClassTeacher;
import com.lms.schoolEntity.Principal;
import com.lms.schoolRepository.ClassTeacherRepository;
import com.lms.schoolRepository.PrincipalRepository;
import com.lms.schoolServiceIF.PrincipalServiceIF;



@Service
public class PrincipalServiceimpl implements PrincipalServiceIF {

	
	@Autowired
	private PrincipalRepository principalRepository;
	
	@Autowired
	private ClassTeacherRepository classTeacherRepository;
	
	@Override
	public Principal registerPrincipal(Principal principal) {
		// TODO Auto-generated method stub
		Date date = new Date();
		principal.setRegisDate(date);
		principal.setUpdateDate(date);
		return principalRepository.save(principal);
	}
	
	public List<ClassTeacher> getUnapprovedClassTeachers(String schoolName) {
        return classTeacherRepository.findBySchoolNameAndApproved(schoolName, false);
    }

    public List<ClassTeacher> getApprovedClassTeachers(String schoolName) {
        return classTeacherRepository.findBySchoolNameAndApproved(schoolName, true);
    }
	
	@Override
	public void approveClassTeacher(Long principalId, Long classTeacherId) {
        Principal principal = principalRepository.findById(principalId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid principal ID"));
        ClassTeacher classTeacher = classTeacherRepository.findById(classTeacherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid class teacher ID"));

        // Validate if principal matches the school of the class teacher
        if (!principal.getSchoolName().equals(classTeacher.getSchoolName())) {
            throw new IllegalArgumentException("Principal does not match the school of the class teacher");
        }

        // Approve class teacher registration
        classTeacher.setApproved(true);
        classTeacherRepository.save(classTeacher);
    }
}
