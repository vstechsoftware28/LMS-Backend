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
public class Student extends SchoolUser{
	private String standard;
    private String division;
    private String studentId;
    private boolean approved;
}