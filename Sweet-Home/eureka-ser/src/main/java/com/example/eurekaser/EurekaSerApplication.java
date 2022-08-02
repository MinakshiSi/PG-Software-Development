package com.example.eurekaser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSerApplication.class, args);
	}

}
