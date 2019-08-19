package com.neo.sevice.impl;

import com.neo.dao.BlogArticleDao;
import com.neo.model.BlogArticle;
import com.neo.sevice.BlogArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class BlogArticleServiceImpl implements BlogArticleService {
    @Resource
    private BlogArticleDao blogArticleDao;

    @Override
    public List<BlogArticle> getBlogArticleList() {
        return blogArticleDao.findAll();
    }

    @Override
    public BlogArticle getBlogById(Long id) {
        return blogArticleDao.getBlogById(id);
    }

    @Override
    public Page<BlogArticle> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return blogArticleDao.findAll(pageable);
    }

    @Override
    public Optional<BlogArticle> findBlogArticleById(Long id) {

        return blogArticleDao.findById(id);
    }
}
