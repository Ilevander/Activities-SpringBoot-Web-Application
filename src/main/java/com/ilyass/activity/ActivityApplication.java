package com.ilyass.activity;

import java.util.List;

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
	 * Bellow we have many ways to create and instance object using Bean Object
	 */
	@Bean
	public CommandLineRunner start(UserRepository userRepository) {
		//Using lambda expression to avoid Java Verbosity Interface,inheritence,class...
		return args ->{
			
			User u1 = new User(); //NoArgsConstructor
			u1.setFirstName("Ilyass");
	        u1.setLastName("EL AMRI"); 
	        u1.setUserName("ilyass07");
	        u1.setPassword("123");
	        userRepository.save(u1);
	        
	        User u2 = new User(null,"Yassine","Louis","yassne09",null,null); //AllArgsConstructor
	        userRepository.save(u2);
	        
	        //Builder():is a design pattern given by lombok to instance object without need to constructor by specifiying which fields to build in object 
	        User u3 = User.builder()
	        		.firstName("toto")
	        		.lastName("titi")
	        		.build();
	        userRepository.save(u3);
	        
	        List<User> users = userRepository.findAll();
	        users.forEach(u->{
	        	System.out.println(u.toString());
	        });
	        
	        
		};
	}
}
    