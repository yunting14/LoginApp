package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.demo.Model.RoleEnum;
import com.demo.Model.User;
import com.demo.Repository.UserRepository;
import com.demo.Service.UserService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(UserService userService){
		return (args) -> {

			// $2a$10$XaLFtKouE/P5Udpi0wOEQem/FnOHFtPaZ66560hdIwh0JqFHIXFc2
			 
			User user1 = new User("larry.lee@abc.com", "password", "Larry Lee", RoleEnum.EMPLOYEE);
			User user2 = new User("tom.tan@abc.com", "password", "Tom Tan", RoleEnum.MANAGER);

			userService.saveUser(user1);
			userService.saveUser(user2);
		};
	}

}
