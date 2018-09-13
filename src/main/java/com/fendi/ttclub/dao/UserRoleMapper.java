package com.fendi.ttclub.dao;

import com.fendi.ttclub.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer turId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer turId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}