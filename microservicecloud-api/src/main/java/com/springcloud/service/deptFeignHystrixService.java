package com.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springcloud.entity.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 该类用来如果某个服务关闭了, 会返回该服务类,从而快速提示备份信息
 * 
 * @author apple
 *
 */

@Component
public class deptFeignHystrixService implements FallbackFactory<deptFeignService> {

	@Override
	public deptFeignService create(Throwable arg0) {
		return new deptFeignService() {

			@Override
			public Dept getone(long deptno) {

				return new Dept().setDeptno(deptno).setDname("该id" + deptno + "没有对应的信息,null--@HystrixCommand")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public List<Dept> getAll() {

				return null;
			}

			@Override
			public boolean add(Dept dept) {

				return false;
			}
		};
	}

}
