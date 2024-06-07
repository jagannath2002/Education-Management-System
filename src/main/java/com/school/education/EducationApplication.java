package com.school.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EducationApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(EducationApplication.class, args);
		
	}

}
