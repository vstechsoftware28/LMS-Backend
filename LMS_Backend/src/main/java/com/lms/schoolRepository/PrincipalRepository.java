package com.lms.schoolRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.schoolEntity.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, Long>{

}
