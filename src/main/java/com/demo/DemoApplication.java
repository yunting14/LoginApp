package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.Model.RoleEnum;
import com.demo.Model.User;
import com.demo.Repository.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(UserRepository userRepo){
		return (args) -> {
			// List<RoleEnum> roleList = new ArrayList<>();
			// roleList.add(RoleEnum.EMPLOYEE);

			// List<RoleEnum> roleList2 = new ArrayList<>();
			// roleList2.add(RoleEnum.EMPLOYEE);
			// roleList2.add(RoleEnum.MANAGER);

			User user1 = new User("larry.lee@abc.com", "employee", "Larry Lee", RoleEnum.EMPLOYEE);
			User user2 = new User("tom.tan@abc.com", "manager", "Tom Tan", RoleEnum.MANAGER);

			userRepo.saveAllAndFlush(Arrays.asList(user1, user2));
		};
	}

}
