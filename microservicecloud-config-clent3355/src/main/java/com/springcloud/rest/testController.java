package com.springcloud.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	@Value("${spring.application.name}")
	private String springAppName;
	@Value("${server.port}")
	private String serverPort;
	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String eurekaDefauleZone;

	@RequestMapping("/config")
	public Map<String, Object> getConfig() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appName", springAppName);
		map.put("serverPort", serverPort);
		map.put("eurekaZone", eurekaDefauleZone);
		return map;
	}
}
