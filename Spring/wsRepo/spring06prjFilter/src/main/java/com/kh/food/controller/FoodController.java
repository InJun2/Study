package com.kh.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
	
	@GetMapping("/food")
	public String Food(){
		return "food/foodselect";
	}
	
	@PostMapping("/food")
	public String Food(String food, String price) {
		System.out.println("food : " + food);
		System.out.println("price : " + price);
		return "food/foodselect";
	}
}
