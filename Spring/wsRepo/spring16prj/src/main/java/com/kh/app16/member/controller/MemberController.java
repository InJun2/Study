package com.kh.app16.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app16.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) throws IllegalStateException, IOException {
		List<MultipartFile> list = vo.getProfilelist();
		// ������ �ִ��� ������ üũ
		if(!vo.fileValidation()) {
			return "redirect:/errorPage";
		}
		
		for(MultipartFile p : list) {
			System.out.println("�̸� : " + p.getOriginalFilename());
			System.out.println("ũ�� : " + p.getSize());
			System.out.println("Ÿ�� : " + p.getContentType());
			
			// ����
			File file = new File("D:\\develop\\06_FrameWork\\wsRepo\\spring16prj\\src\\main\\webapp\\resources\\file", p.getOriginalFilename());
			p.transferTo(file);
		}
		
		return "redirect:/";
	}
}