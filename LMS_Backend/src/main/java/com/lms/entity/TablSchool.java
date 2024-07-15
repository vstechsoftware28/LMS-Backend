package com.lms.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TablSchool {
	private String schoolName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String principalName;
	private String email;
	private Long telephoneNumber;
	private String state;
	private String district;
	private String taluka;
	private String city;
	private int pincode;
	private LocalDate registrationDate;
	private Date createdAt;
	
	
	
	
	
	
	
	
	
	

}
