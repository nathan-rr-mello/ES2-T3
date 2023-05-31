package com.service.subreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.service.subreg.domain.model")
public class SubRegApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubRegApplication.class, args);
	}
}