package com.kh.app04.color;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app05.color.model.vo.ColorVo;

@Controller
@RequestMapping("/color")
public class ColorController {
	
	@GetMapping("/select_color")
	public String selectColor() {
		return "color/select_color";
	}
	
	@PostMapping("/select_color")
	public String selectColor(ColorVo colorVo) {
		String[] colors = colorVo.getColor();
		for(String c : colors) {
			System.out.println(c);
		}
		
		return "redirect:/color/select_color";
	}
}
