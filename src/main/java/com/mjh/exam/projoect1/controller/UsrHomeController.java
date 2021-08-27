package com.mjh.exam.projoect1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	@RequestMapping("/usr/home/main")
	public String main() {
		return "usr/home/main";
	}
	
	@RequestMapping("/")
	public String showBoot() {
		return "redirect:/usr/home/main";
	}
}
