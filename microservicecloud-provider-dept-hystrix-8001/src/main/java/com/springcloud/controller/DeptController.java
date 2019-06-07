package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.entity.Dept;
import com.springcloud.service.deptService;

@RestController
public class DeptController {
	@Autowired
	private deptService deptService;

	@RequestMapping(value = "/dept/getone/{id}", method = RequestMethod.GET)
	// 一旦调用的方法抛出了异常,会立即走方法名为fallbackMethod的方法
	@HystrixCommand(fallbackMethod = "hystrix_getone")
	public Dept getone(@PathVariable("id") Long id) {
		Dept dept = deptService.findById(id);
		if (dept == null) {
			throw new RuntimeException("deptno为" + id + "的用户不存在");
		}
		return dept;
	}

	public Dept hystrix_getone(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该id" + id + "没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

}
