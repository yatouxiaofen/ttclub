package com.fendi.ttclub.dao;

import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer trId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer trId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectRoleList();

}