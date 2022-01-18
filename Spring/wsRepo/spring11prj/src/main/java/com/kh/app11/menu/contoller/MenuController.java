package com.kh.app11.menu.contoller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app11.menu.entity.menuVo;

@Controller
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private SqlSession sqlSession;

	@GetMapping("insert")
	public String insert() {
		return "menu/insert";
	}
	
	@PostMapping("insert")
	public String insert2(menuVo vo) {
		sqlSession.insert("menu.insert", vo);
		return "redirect:/menu/insert";
	}
	
	@GetMapping("list")
	public String list(Model model) {	// Model 이용시 spring이 알아서 가져옴
		List<menuVo> menulist = sqlSession.selectList("menu.select");
		// DB에서 리스트로 객체 리스트 가져옴
		model.addAttribute("list", menulist);
		
		return "menu/list";
	}
}
