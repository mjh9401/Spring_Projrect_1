package com.mjh.exam.projoect1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mjh.exam.projoect1.vo.Article;

@Mapper
public interface ArticleRepository {

	public void writeArticle(@Param("title") String title,@Param("body") String body);

	public List<Article> list();

	public Article detail(@Param("id") int id);

	public void update(@Param("id") int id,@Param("title") String title,@Param("body") String body);

	public void delete(@Param("id") int id);

}
