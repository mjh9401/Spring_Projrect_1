package com.mjh.exam.projoect1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjh.exam.projoect1.repository.ArticleRepository;
import com.mjh.exam.projoect1.vo.Article;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository;
	
	public void write(String title, String body) {
		articleRepository.writeArticle(title,body);
	}

	public List<Article> list() {
		
		return articleRepository.list();
	}

	public Article detail(int id) {
		return articleRepository.detail(id);
	}

	public void update(int id, String title, String body) {
		articleRepository.update(id,title,body);
	}

	public void delete(int id) {
		articleRepository.delete(id);
	}
	

	

}
