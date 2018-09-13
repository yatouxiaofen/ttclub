package com.fendi.ttclub.service.impl.website;

import com.fendi.ttclub.dao.website.CategoryMapper;
import com.fendi.ttclub.entity.website.Category;
import com.fendi.ttclub.service.website.CategoryService;
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
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getList(Category category) {
        return categoryMapper.getList(category);
    }

    @Override
    public int save(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int edit(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public int delete(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }
}
