package com.example.neighbor.test.dao;

import java.util.List;

import com.example.neighbor.dept.dto.DeptDto;

public interface TestDao {

	String getTime();

	List<DeptDto> getUser();

	int insertUser(DeptDto dto);
}
