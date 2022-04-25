package io.github.phatnt95.todolistapp;

import io.github.phatnt95.todolistapp.entity.EIssueType;
import io.github.phatnt95.todolistapp.entity.EStatus;
import io.github.phatnt95.todolistapp.entity.Task;
import io.github.phatnt95.todolistapp.service.email.EmailService;
import io.github.phatnt95.todolistapp.service.email.EmailServiceImpl;
import io.github.phatnt95.todolistapp.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200/")
@EnableAutoConfiguration
@SpringBootApplication
//@EnableScheduling
public class TodoListAppApplication {

	@Autowired
	private TaskService taskService;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoListAppApplication.class, args);
	}

}
