package com.lms.schoolServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.schoolEntity.SubjectTeacher;
import com.lms.schoolRepository.SubjectTeacherRepository;
import com.lms.schoolServiceIF.SubjectTeacherServiceIF;



@Service
public class SubjectTeacherServiceImpl implements SubjectTeacherServiceIF{
	
	@Autowired
	private SubjectTeacherRepository subjectTeacherRepository;
	
	@Override
	public SubjectTeacher registerSubjectTeacher(SubjectTeacher subjectTeacher) {
		// TODO Auto-generated method stub
		Date date = new Date();
		subjectTeacher.setRegisDate(date);
		subjectTeacher.setUpdateDate(date);
		return subjectTeacherRepository.save(subjectTeacher);
		
	}

}
