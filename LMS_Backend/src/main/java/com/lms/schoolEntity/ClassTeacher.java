package com.lms.schoolEntity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClassTeacher extends Teacher{
	private String standard;
	private String division;
	private boolean approved;
}
