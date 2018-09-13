package com.fendi.ttclub.dao.website;

import com.fendi.ttclub.entity.website.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    List<Category> getList(Category category);
}