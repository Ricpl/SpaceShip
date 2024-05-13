package com.spacecrafts.spacecrafts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpacecraftsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacecraftsApplication.class, args);
	}

}
