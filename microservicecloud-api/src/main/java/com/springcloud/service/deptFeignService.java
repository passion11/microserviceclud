package com.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.entity.Dept;

//改类为公共接口服务类,让调用者通过feign找到
//eureka上的服务,以下方法为feign的name属性名的服务的三个方法
//fallbackfactory:如果某个提供者服务关闭了,调用改接口者会它指定的类
@FeignClient(name = "MICROSERVICECLOUD-DEPT-PROVIDER", fallbackFactory = deptFeignHystrixService.class)
public interface deptFeignService {
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept);

	@RequestMapping(value = "/dept/getall", method = RequestMethod.GET)
	public List<Dept> getAll();

	@RequestMapping(value = "/dept/getone/{id}", method = RequestMethod.GET)
	public Dept getone(@PathVariable("id") long deptno);
}
