package com.neo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BlogArticle {
    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    private Long id; // 用户的唯一标识
    @Column(nullable = false, length = 50) // 映射为字段，值不能为空
    private String title;
    private String author;
    private Date date;
    //@NotEmpty(message = "摘要不能为空")
    //@Column(nullable = false) // 映射为字段，值不能为空
    private String summary;
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Column(nullable = false) // 映射为字段，值不能为空
    private String content;
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Column(nullable = false) // 映射为字段，值不能为空
    private String htmlContent; // 将 md 转为 html

    @Override
    public String toString() {
        return "BlogArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
