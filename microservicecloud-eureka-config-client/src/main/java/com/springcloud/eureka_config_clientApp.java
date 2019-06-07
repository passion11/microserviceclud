package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eureka_config_clientApp {
	public static void main(String[] args) {
		SpringApplication.run(eureka_config_clientApp.class, args);
	}

}
