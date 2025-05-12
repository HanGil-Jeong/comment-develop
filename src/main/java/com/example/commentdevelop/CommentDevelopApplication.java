package com.example.commentdevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CommentDevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentDevelopApplication.class, args);
	}

}
