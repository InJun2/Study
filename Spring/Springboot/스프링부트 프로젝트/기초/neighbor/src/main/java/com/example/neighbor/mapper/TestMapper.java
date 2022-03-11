package com.example.neighbor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.neighbor.dept.dto.DeptDto;

@Mapper							// mapper 지정, interface만 가능
public interface TestMapper {
	
	@Select("select sysdate from dual")			// 어노테이션을 이용하여 데이터베이스 접근
	public String getTime();
	
	public List<DeptDto> getUser();				// application.properties에 지정해둔 mapper.xml로 데이터베이스 접근 ( mapper의 이름은 해당 클래스의 이름과 같아야 함 )
												// 또한 메소드의 이름과 해당 mapper.xml의 id는 동일해야함

	@Insert("insert into myuser(name, age, home) values(#{name}, ${age}, #{home})")
	public int insertUser(DeptDto dto);
}
