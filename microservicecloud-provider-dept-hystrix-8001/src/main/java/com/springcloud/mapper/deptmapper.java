package com.springcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springcloud.entity.Dept;

@Mapper
public interface deptmapper {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
