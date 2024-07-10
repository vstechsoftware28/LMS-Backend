package com.lms.schoolRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.schoolEntity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
