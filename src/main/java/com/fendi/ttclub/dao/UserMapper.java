package com.fendi.ttclub.dao;

import com.fendi.ttclub.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer tuId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer tuId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(User user);
}