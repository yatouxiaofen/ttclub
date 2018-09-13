package com.fendi.ttclub.service.website;

import java.util.List;

import com.fendi.ttclub.entity.website.Category;
import com.fendi.ttclub.entity.website.TimeLine;

public interface CategoryService {
    /**
     * 查询全部分类
     * @return
     */
    List<Category> getList(Category category);

    int save(Category category);

    Category getById(Integer id);

    int edit(Category category);

    int delete(Integer id);
}
