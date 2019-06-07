package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Dept;
import com.springcloud.service.deptService;

@RestController
public class DeptController {
	@Autowired
	private deptService deptService;
	@Autowired
	private DiscoveryClient dc;

	/*
	 * @RequestBody:仅仅能将前端的json对象中的字符串绑定到参数上
	 * 
	 */
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}

	@RequestMapping(value = "/dept/getall", method = RequestMethod.GET)
	public List<Dept> getAll() {
		return deptService.findAll();
	}

	/*
	 * @Pathvariable:当使用@RequestMapping URI template 样式映射时， 即 someUrl/{paramId},
	 * 这时的paramId可通过 @Pathvariable注解绑定它传过来的值到方法的参数上。
	 */
	@RequestMapping(value = "/dept/getone/{id}", method = RequestMethod.GET)
	public Dept getone(@PathVariable("id") long deptno) {
		return deptService.findById(deptno);
	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = dc.getServices();
		System.out.println("*********************" + list);
		List<ServiceInstance> serlist = dc.getInstances("microservicecloud-dept8001");
		for (ServiceInstance sc : serlist) {
			System.out.println(sc.getHost() + "\t" + sc.getPort() + "\t" + sc.getServiceId());
		}
		return dc;
	}

}
