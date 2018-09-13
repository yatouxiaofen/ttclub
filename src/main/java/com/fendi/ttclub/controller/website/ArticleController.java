package com.fendi.ttclub.controller.website;

import com.fendi.ttclub.bean.ResponseBean;
import com.fendi.ttclub.entity.website.Article;
import com.fendi.ttclub.entity.website.Category;
import com.fendi.ttclub.service.website.ArticleService;
import com.fendi.ttclub.service.website.CategoryService;
import com.fendi.ttclub.util.ResponseBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章管理
 *
 * @author LiuSuFen
 * @version [版本号, 2018/9/11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@Controller
@RequestMapping("/article")
public class ArticleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/index")
    public String index(){
        return "website/article/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Article> getList(Article article){
        List<Article> articles = articleService.getList(article);
        return articles;
    }

    @RequestMapping("/toSave")
    public String toSave(Article article){
        return "website/article/add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseBean save(Article article){
        int count = articleService.save(article);
        if (count<=0){
            return ResponseBeanUtil.fail("添加失败！");
        }
        return ResponseBeanUtil.success("添加成功！");
    }

    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Model model){
        Article article = articleService.getById(id);
        model.addAttribute("article", article);
        return "website/article/edit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResponseBean edit(Article article){
        int count = articleService.edit(article);
        if (count <= 0)
        {
            return ResponseBeanUtil.fail("修改失败！");
        }
        return ResponseBeanUtil.success("修改成功！");
    }

    @RequestMapping("/remove")
    @ResponseBody
    public ResponseBean delete(Integer id){
        int count = articleService.delete(id);
        if(count<=0){
            return ResponseBeanUtil.fail("删除失败！ ");
        }
        return ResponseBeanUtil.success("删除成功！");
    }
}
