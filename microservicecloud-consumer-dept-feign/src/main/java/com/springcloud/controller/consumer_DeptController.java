package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Dept;
import com.springcloud.service.deptFeignService;

@RestController
@RequestMapping("/consumer/dept")
public class consumer_DeptController {
	@Autowired
	private deptFeignService dfs;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Dept> getall() {
		return dfs.getAll();
	}

	@RequestMapping(value = "/getone/{id}", method = RequestMethod.GET)
	public Dept getone(@PathVariable("id") Long deptno) {
		return dfs.getone(deptno);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean adddept(Dept dept) {
		return dfs.add(dept);
	}
}
