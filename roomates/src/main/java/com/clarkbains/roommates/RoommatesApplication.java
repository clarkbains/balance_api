package com.clarkbains.roommates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class RoommatesApplication {

	public static void main(String[] args) {
		System.out.println(new Timestamp(System.currentTimeMillis()));
		SpringApplication.run(RoommatesApplication.class, args);
	}

}
