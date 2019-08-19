package com.neo.controller.FrontDesk;

import com.neo.dao.BlogArticleDao;
import com.neo.model.BlogArticle;
import com.neo.sevice.BlogArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class FrontDeskController {

    @Resource
    BlogArticleService blogArticleService;

    @Resource
    BlogArticleDao blogArticleDao;
    @GetMapping("/home/main")
    public String list(Model model){
        List<BlogArticle> blog = blogArticleService.getBlogArticleList();
        model.addAttribute("blogAll",blog);
        return "/home/main";
    }

    @GetMapping(value = "/home/main/{id}")
    public String blogEdit (@PathVariable("id")Long id, Model model){
        BlogArticle blog = blogArticleService.getBlogById(id);
        model.addAttribute("blog",blog);
        return "/home/preview";
    }
}
