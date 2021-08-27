package com.mjh.exam.projoect1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mjh.exam.projoect1.service.ArticleService;
import com.mjh.exam.projoect1.vo.Article;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/write")
	@ResponseBody
	public void write(String title,String body) {
		articleService.write(title,body);
	}
	
	@RequestMapping("/usr/article/list")
	public String list(Model model) {
		List<Article>articles = articleService.list();
		model.addAttribute("articles", articles);

		return "usr/article/list";
	}
	
	@RequestMapping("/usr/article/detail")
	public String list(int id, Model model) {
		Article article = articleService.detail(id);
		
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}
	
	@RequestMapping("/usr/article/update")
	@ResponseBody
	public void update(int id,String title,String body) {
		articleService.update(id,title,body);
	}
	
	@RequestMapping("/usr/article/delete")
	@ResponseBody
	public void delete(int id) {
		articleService.delete(id);
	}
}
