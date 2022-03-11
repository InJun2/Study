package com.example.neighbor.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.neighbor.dept.dto.DeptDto;
import com.example.neighbor.mapper.TestMapper;

@Repository
public class TestDaoImpl implements TestDao{

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public String getTime() {
		return testMapper.getTime();
	}

	@Override
	public List<DeptDto> getUser() {
		return testMapper.getUser();
	}

	@Override
	public int insertUser(DeptDto dto) {
		return testMapper.insertUser(dto);
	}
	
	
}
