package com.kh.app07.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/insert")
	public String insert() {
		return "menu/insert";
	}
	
	@PostMapping("/insert")
	public String insert(String menu, int price) {
		// db insert
		String sql = "insert into menu(menu, price) values(?,?)";
		Object[] params = new Object[]{menu, price};
		
		jdbcTemplate.update(sql, params);
		
		System.out.println("menu : " + menu +" price : " + price + " DB 연결하기");
		return "menu/insert";
	}
	
}
