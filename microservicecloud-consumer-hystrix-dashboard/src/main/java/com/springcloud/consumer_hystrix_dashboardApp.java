package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class consumer_hystrix_dashboardApp {
	public static void main(String[] args) {
		SpringApplication.run(consumer_hystrix_dashboardApp.class, args);
	}

}
