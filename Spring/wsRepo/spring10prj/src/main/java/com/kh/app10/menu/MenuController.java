package com.kh.app10.menu;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app10.menu.model.vo.MenuVo;

@Controller
@RequestMapping("menu")
public class MenuController {
//	@Autowired
//	private JdbcTemplate jt;
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("insert")
	public String insert() {
		return "menu/insert";
	}
	
	@PostMapping("insert")
	public String insert2(MenuVo m) {
		
//		String sql = "insert into menu values(?,?)";
//		Object[] params = {menu, price};
//		jt.update(sql,params);
		sqlSession.insert("menu.insertMenu", m);
		
		return "redirect:/menu/insert";
	}
}
