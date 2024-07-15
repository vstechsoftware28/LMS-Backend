package com.lms.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.TablSchool;

public interface SchoolRepositary extends JpaRepository<TablSchool, Long> {

}
