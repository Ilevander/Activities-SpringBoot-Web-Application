package com.ilyass.activity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ilyass.activity.models.User;
import com.ilyass.activity.repository.UserRepository;

@SpringBootApplication
public class ActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityApplication.class, args);
	}

	/*
	 * @Bean : Gives context to be lunched at the begining of the application , foeach method used by @Bean
	 * start(UserRepository userRepository) As a DI like @Autowiered private StudentRepository studentRepository
	 */
	@Bean
	public CommandLineRunner start(UserRepository userRepository) {
		//Using lambda expression to avoid Java Verbosity Interface,inheritence,class...
		return args ->{
			User user = new User(); 
			user.setFirstName(null);
	        user.setLastName(null); 

	        userRepository.save(user);
		};
	}
}
    