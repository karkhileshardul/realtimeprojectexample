package com.shardul.realtimeprojectexample.realtimeprojectexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = {"com.shardul.entity"})
@ComponentScan(basePackages ={"com.shardul.rest","com.shardul.dao","com.shardul.service"})
@SpringBootApplication
public class RealtimeprojectexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimeprojectexampleApplication.class, args);
	}

}

