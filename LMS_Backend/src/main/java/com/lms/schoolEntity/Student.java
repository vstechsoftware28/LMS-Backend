package com.lms.schoolEntity;

import java.util.List;

import com.lms.entity.TablSubject;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "student")
    private List<TablSubject> tablSubjects;
}