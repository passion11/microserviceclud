package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 注册到eureka中心开启
@EnableEurekaClient
// 服务发现开启
@EnableDiscoveryClient
// 开启熔断机制
@EnableCircuitBreaker
public class dept_provider_hystrix_8001 {
	public static void main(String[] args) {
		SpringApplication.run(dept_provider_hystrix_8001.class, args);

	}

}
