package com.mjh.exam.projoect1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@ResponseBody
	public List<Article> list() {
		List<Article>articles = articleService.list();
		
		return articles;
	}
	
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Article list(int id) {
		Article article = articleService.detail(id);
		
		return article;
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
