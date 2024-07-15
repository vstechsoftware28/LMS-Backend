package com.lms.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.annotation.Generated;
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
public class TablRecordedVideo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String topic;
	private String subTopic;
	private String description;
	private String uploadVideo;
	private String Notes;
	private Date credtedAt;
	private Date updatedAt;
	
	
	
	

}
