package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
/*
 * 在启动微服务的时候,就能加载我们自定义的Ribbon配置类,使之生效
 * 
 * @RibbonClient(name="",configuration=xx.class)
 */
@RibbonClient(name = "MICROSERVICECLOUD-DEPT-PROVIDER", configuration = MySelfRule.class)
public class consumer_dept_app80 {
	public static void main(String[] args) {
		SpringApplication.run(consumer_dept_app80.class, args);
	}

}
