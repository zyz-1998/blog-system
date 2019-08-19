package com.neo.controller;

import com.neo.dao.BlogArticleDao;
import com.neo.model.BlogArticle;
import com.neo.sevice.BlogArticleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogArticleController {
    private static String UPLOADED_FOLDER = "E://temp//";
    @Resource
    BlogArticleService blogArticleService;

    @Resource
    BlogArticleDao blogArticleDao;
    @GetMapping("/admin")
    public String list(Model model){
        List<BlogArticle> blog = blogArticleService.getBlogArticleList();
        model.addAttribute("blogAll",blog);
        return "/admin";
    }

    @GetMapping(value = "/admin/{id}")
    public String blogEdit (@PathVariable("id")Long id, Model model){
        BlogArticle blog = blogArticleService.getBlogById(id);
        model.addAttribute("blog",blog);
        return "/edit";
    }

//    CreateBlog start
    @RequestMapping("createBlog")
    public String   editor(){
        return "/createBlog";
    }

    @RequestMapping("submit")
    @ResponseBody
    public void  submit(BlogArticle blog){
        System.out.println(blog.getContent());
        System.out.println(blog.getHtmlContent());
        blogArticleDao.save(blog);
    }

    @RequestMapping("wxcontent")
    @ResponseBody
    public  BlogArticle wxcontent(){
        BlogArticle blog =    blogArticleDao.findBlogById(2l);
        System.out.println(blog.getHtmlContent());
        return  blog;
    }

    //处理文件上传
    @RequestMapping(value="/uploadimg")
    public @ResponseBody
    Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        System.out.println(request.getContextPath());
        String realPath = UPLOADED_FOLDER;
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
/*        File targetFile = new File(realPath, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }*/
        //保存
        try {
            /*            file.transferTo(targetFile);*/
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url",UPLOADED_FOLDER+fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        System.out.println(resultMap.get("success"));
        return resultMap;


    }
    /**
     *
     */
//    @GetMapping(value = "/admin/{pageId}")
//    public String page(@PathVariable("pageId")Integer pageId, Model model){
//        if(pageId==null||pageId<=0){
//            pageId=0;
//        }
//        Page<BlogArticle> blog = blogArticleService.findAll(pageId, 3);
//        model.addAttribute("blogAll",blog);
//        return "/admin";
//    }
}
