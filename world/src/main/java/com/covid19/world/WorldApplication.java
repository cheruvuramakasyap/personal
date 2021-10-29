package com.covid19.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class WorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldApplication.class, args);
	}

}
