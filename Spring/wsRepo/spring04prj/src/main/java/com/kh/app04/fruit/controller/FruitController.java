package com.kh.app04.fruit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fruit")
public class FruitController {

	@GetMapping("/select_fruit")
	public String select() {
		return "fruit/select";
	}
	
	@PostMapping("/select_fruit")
	public String select(@RequestParam List<String> fruit) {
		for(String f : fruit) {
			System.out.println(f);
		}
		
		return "redirect:/fruit/select_fruit";
	}
}
