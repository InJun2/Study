package com.example.neighbor.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neighbor.dept.dto.DeptDto;
import com.example.neighbor.test.dao.TestDao;

@Service
public class TestServiceImple implements TestService{

	@Autowired
	private TestDao dao;

	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public List<DeptDto> getUser() {
		return dao.getUser();
	}

	@Override
	public int insertUser(DeptDto dto) {
		return dao.insertUser(dto);
	}
	
}
