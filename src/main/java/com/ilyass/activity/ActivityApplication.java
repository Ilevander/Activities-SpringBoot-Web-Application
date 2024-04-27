package com.ilyass.activity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ilyass.activity.models.Student;
import com.ilyass.activity.repository.StudentRepository;

@SpringBootApplication
public class ActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityApplication.class, args);
	}

	/*
	 * @Bean : Gives context to be lunched at the begining of the application , foeach method used by @Bean
	 * start(StudentRepository studentRepository) As a DI like @Autowiered private StudentRepository studentRepository
	 */
	@Bean
	public CommandLineRunner start(StudentRepository studentRepository) {
		//Using lambda expression to avoid Java Verbosity Interface,inheritence,class...
		return args ->{
			Student student = new Student(); 
			student.setStudentId("S123"); 
	        student.setDepartment("Computer Science"); 

	        studentRepository.save(student);
		};
	}
}
    