package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.Dept;

public interface deptService {
	public boolean addDept(Dept dept);

	public List<Dept> findAll();

	public Dept findById(Long deptno);
}
