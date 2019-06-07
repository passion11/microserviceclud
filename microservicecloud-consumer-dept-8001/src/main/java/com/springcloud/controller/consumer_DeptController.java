package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.entity.Dept;

@RestController
@RequestMapping("/consumer/dept")
public class consumer_DeptController {
	@Autowired
	private RestTemplate restTemplate;

	private static final String consumer_url_prifix = "http://MICROSERVICECLOUD-DEPT-PROVIDER/";

	@RequestMapping(value = "/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(consumer_url_prifix + "dept/add", dept, Boolean.class);
	}

	@RequestMapping(value = "/getone/{id}")
	public Dept getOne(@PathVariable("id") Long deptno) {
		return restTemplate.getForObject(consumer_url_prifix + "dept/getone/" + deptno, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getall")
	public List<Dept> getAll() {
		return restTemplate.getForObject(consumer_url_prifix + "dept/getall", List.class);
	}

	@RequestMapping("/getinfo")
	public Object getprovider_info() {
		return restTemplate.getForObject(consumer_url_prifix + "dept/discovery", Object.class);
	}
}
