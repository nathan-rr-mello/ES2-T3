package com.service.subreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SubRegApplication {

	@GetMapping("/")
	public String Hello() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SubRegApplication.class, args);
	}

}
