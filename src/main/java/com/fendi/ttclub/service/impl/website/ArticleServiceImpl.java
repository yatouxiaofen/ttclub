package com.fendi.ttclub.service.impl.website;

import com.fendi.ttclub.dao.website.ArticleMapper;
import com.fendi.ttclub.entity.website.Article;
import com.fendi.ttclub.service.website.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 一句话功能简述
 * 功能详细描述
 *
 * @author LiuSuFen
 * @version [版本号, 2018/9/11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getList(Article article) {
        return articleMapper.getList(article);
    }

    @Override
    public int save(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int edit(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public int delete(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }
}
