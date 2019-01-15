package com.codegym.Customer1234;

import com.codegym.Customer1234.service.GroupService;
import com.codegym.Customer1234.service.StaffService;
import com.codegym.Customer1234.service.impl.GroupServiceImpl;
import com.codegym.Customer1234.service.impl.StaffServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Customer1234Application {

	public static void main(String[] args) {
		SpringApplication.run(Customer1234Application.class, args);
	}
	@Bean
	public StaffService staffService(){return new StaffServiceImpl();
	}

	@Bean
	public GroupService groupService(){return new GroupServiceImpl();
	}
}

