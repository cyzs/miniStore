package com.example.hxsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HxspApplication {

	public static void main(String[] args) {
		SpringApplication.run(HxspApplication.class, args);
	}

}

