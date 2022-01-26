package com.kh.app17.gallery.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app17.gallery.service.GalleryService;
import com.kh.app17.gallery.vo.GalleryVo;

@Controller
@RequestMapping("gallery")
public class GalleryContoller {
	
	@Autowired
	private GalleryService service;
	
	@GetMapping("enroll")
	public String enroll() {
		return "gallery/enroll";
	}
	
	@PostMapping("enroll")
	public String enroll(GalleryVo vo, MultipartFile f) throws IllegalStateException, IOException {
		if(f.isEmpty()) {
			return "redirect:/errorPage";
		}
		
		int result = service.enroll(vo, f);
		
		if(result <1) {
			return "redirect:/errorPage";
		}
		return "redirect:/gallery/enroll";
	}
}
