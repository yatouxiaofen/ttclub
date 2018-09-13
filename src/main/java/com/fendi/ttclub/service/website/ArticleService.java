package com.fendi.ttclub.service.website;

import com.fendi.ttclub.entity.website.Article;

import java.util.List;


public interface ArticleService {
    /**
     * 查询全部文章
     * @return
     */
    List<Article> getList(Article article);

    int save(Article article);

    Article getById(Integer id);

    int edit(Article article);

    int delete(Integer id);
}
