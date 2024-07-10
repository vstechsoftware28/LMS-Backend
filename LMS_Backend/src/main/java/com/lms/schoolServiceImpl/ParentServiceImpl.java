package com.lms.schoolServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.schoolEntity.Parent;
import com.lms.schoolRepository.ParentRepository;
import com.lms.schoolServiceIF.ParentServiceIF;


@Service
public class ParentServiceImpl implements ParentServiceIF{

	@Autowired
	private ParentRepository parentRepository;
	
	@Override
	public Parent registerParent(Parent parent) {
		Date date = new Date();
		parent.setRegisDate(date);
		parent.setUpdateDate(date);
		parent.setApproved(false);
		return parentRepository.save(parent);
	}

}
