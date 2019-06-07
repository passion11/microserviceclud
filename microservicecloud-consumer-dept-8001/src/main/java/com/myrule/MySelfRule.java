package com.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * 自定义Ribbon规则配置类
 * 
 * @author apple
 *
 */
@Configuration
public class MySelfRule {
	@Bean
	public IRule getrule() {
		return new RandomRule_ZY();// 自定义为ribbon随机策略
	}
}
