package com.lexmedd.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LexMeddApplication {

	public static void main(String[] args) {
		SpringApplication.run(LexMeddApplication.class, args);
	}

}
