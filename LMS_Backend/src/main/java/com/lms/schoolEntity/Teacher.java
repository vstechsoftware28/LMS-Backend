package com.lms.schoolEntity;

import com.lms.schoolEnum.UserSubType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher extends SchoolUser{
	@Enumerated(EnumType.STRING)
    private UserSubType userSubType;
}
