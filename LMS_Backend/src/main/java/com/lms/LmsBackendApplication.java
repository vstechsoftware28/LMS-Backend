package com.lms;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsBackendApplication.class, args);
		Date date = new Date();
		LocalDate localDate = LocalDate.now();
		System.out.println(date);
		System.out.println(localDate);
	}

}
