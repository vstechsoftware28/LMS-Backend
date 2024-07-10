package com.lms.schoolEntity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Parent extends SchoolUser {
	private String childName;
	private String childId;
	private String childStandard;
	private String childDivision;
	private boolean approved;
}
