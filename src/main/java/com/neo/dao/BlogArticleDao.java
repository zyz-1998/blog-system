package com.neo.dao;

import com.neo.model.BlogArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogArticleDao extends JpaRepository<BlogArticle, Long>{

    Optional<BlogArticle> findById(Long id);
    public BlogArticle findBlogById(Long id);
    void deleteById(Long id);

    BlogArticle getBlogById(Long id);
}
