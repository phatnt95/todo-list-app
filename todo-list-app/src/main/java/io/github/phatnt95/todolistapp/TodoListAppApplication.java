package io.github.phatnt95.todolistapp;

import io.github.phatnt95.todolistapp.service.email.EmailService;
import io.github.phatnt95.todolistapp.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@EnableAutoConfiguration
@SpringBootApplication
//@EnableScheduling
public class TodoListAppApplication {

	@Autowired
	private EmailService emailService;
	
	public static void main(String[] args) {
//		emailService.sendSimpleMessage("phatnguyen.uit95@gmail.com", "Subject", "text");
		SpringApplication.run(TodoListAppApplication.class, args);
	}

}
