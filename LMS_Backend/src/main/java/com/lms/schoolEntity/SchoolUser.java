package com.lms.schoolEntity;

import com.lms.schoolCollegeBaseEntity.User;
import com.lms.schoolEnum.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SchoolUser extends User {
	private String schoolName;

	@Enumerated(EnumType.STRING)
	private UserType userType;
}