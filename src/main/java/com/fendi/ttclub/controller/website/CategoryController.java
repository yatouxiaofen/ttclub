package com.fendi.ttclub.controller.website;

import com.fendi.ttclub.bean.ResponseBean;
import com.fendi.ttclub.entity.website.Category;
import com.fendi.ttclub.entity.website.TimeLine;
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
 * 一句话功能简述
 * 功能详细描述
 *
 * @author LiuSuFen
 * @version [版本号, 2018/9/11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
@RequestMapping("/cat")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/index")
    public String index(){
        return "website/category/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Category> getList(Category category){
        List<Category> categorys = categoryService.getList(category);
        return categorys;
    }

    @RequestMapping("/toSave")
    public String toSave(Category category){
        return "website/category/add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseBean save(Category category){
        int count = categoryService.save(category);
        if (count<=0){
            return ResponseBeanUtil.fail("添加失败！");
        }
        return ResponseBeanUtil.success("添加成功！");
    }

    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Model model){
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "website/category/edit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResponseBean edit(Category category){
        int count = categoryService.edit(category);
        if (count <= 0)
        {
            return ResponseBeanUtil.fail("修改失败！");
        }
        return ResponseBeanUtil.success("修改成功！");
    }

    @RequestMapping("/remove")
    @ResponseBody
    public ResponseBean delete(Integer id){
        int count = categoryService.delete(id);
        if(count<=0){
            return ResponseBeanUtil.fail("删除失败！ ");
        }
        return ResponseBeanUtil.success("删除成功！");
    }
}
