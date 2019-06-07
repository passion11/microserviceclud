package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class provider_zuul_9527App {
	public static void main(String[] args) {
		SpringApplication.run(provider_zuul_9527App.class, args);

	}

}
