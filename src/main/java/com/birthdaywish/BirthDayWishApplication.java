package com.birthdaywish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BirthDayWishApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthDayWishApplication.class, args);
	}

}
