package com.mjh.exam.projoect1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjh.exam.projoect1.vo.Rq;

@Controller
public class UsrHomeController {
	@Autowired
	Rq rq;
	
	@RequestMapping("/usr/home/main")
	public String main(Model model) {
		
//		model.addAttribute("rq", rq);
		
		return "usr/home/main";
	}
	
	@RequestMapping("/")
	public String showBoot() {
		return "redirect:/usr/home/main";
	}
}
