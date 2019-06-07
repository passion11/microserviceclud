package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.entity.Dept;
import com.springcloud.mapper.deptmapper;
import com.springcloud.service.deptService;

@Service
public class deptServiceImpl implements deptService {
	@Autowired
	private deptmapper deptmapper;

	@Override
	public List<Dept> findAll() {

		return deptmapper.findAll();
	}

	@Override
	public Dept findById(Long deptno) {

		return deptmapper.findById(deptno);
	}

	@Override
	public boolean addDept(Dept dept) {

		return deptmapper.addDept(dept);
	}

}
