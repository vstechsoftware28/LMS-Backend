package com.lms.schoolCollegeBaseEntity;




import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
@MappedSuperclass

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String password;
	private String confirmPassword;
	private String gender;
	private LocalDate dob;
	private String state;
	private String district;
	private String subDistrict;
	private String city;
	private Date regisDate;
	private Date updateDate;
	@Enumerated(EnumType.STRING)
	private InstitutionType institutionType;
		
}


