package com.FinalExam;

import com.FinalExam.models.Player;
import com.FinalExam.service.PlayerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FinalExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalExamApplication.class, args);
	}

}
