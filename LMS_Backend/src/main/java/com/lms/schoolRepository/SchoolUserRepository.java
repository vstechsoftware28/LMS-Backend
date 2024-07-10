package com.lms.schoolRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.schoolEntity.SchoolUser;

public interface SchoolUserRepository extends JpaRepository<SchoolUser, Long>{

}
