package com.lms.entity;




import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.web.multipart.MultipartFile;

import com.lms.schoolEntity.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TablSubject {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subjectCode;
	private String subjectName;
	private String teacherName;
	private String className;
	private char division;
	private String description;
	private int credit;
	 private String file;
	 private boolean status;
	 private Date createdAt;
	 private Date updatedAt;
	 
	 @ManyToOne
	    @JoinColumn(name = "student_id", referencedColumnName = "id")
	    private Student student;

	public TablSubject(String subjectName, String teacherName, Student student) {
		super();
		this.subjectName = subjectName;
		this.teacherName = teacherName;
		this.student = student;
	}
	 
	 
	 
	 
	
	

}
