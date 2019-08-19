package com.neo.sevice;

import com.neo.model.BlogArticle;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BlogArticleService {
    public List<BlogArticle> getBlogArticleList();
    public BlogArticle getBlogById(Long id);
    public Page<BlogArticle> findAll(int page,int pageSize);
    public Optional<BlogArticle> findBlogArticleById(Long id);
}
