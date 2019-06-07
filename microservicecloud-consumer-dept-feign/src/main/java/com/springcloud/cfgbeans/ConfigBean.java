package com.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	@Bean
	// Spring Cloud Ribbon 是基于Netfix Ribbon 实现的一套客户端 负载均衡的工具
	// loadBalanced:开启负载均衡
	@LoadBalanced
	public RestTemplate geTemplate() {

		return new RestTemplate();
	}

	/*
	 * @Bean public IRule getIRule() { return new RandomRule(); }
	 */

}
