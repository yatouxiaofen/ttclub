package com.fendi.ttclub.dao;

import com.fendi.ttclub.entity.RoleRight;

public interface RoleRightMapper {
    int deleteByPrimaryKey(Integer trrId);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    RoleRight selectByPrimaryKey(Integer trrId);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);

    int deleteByRoleId(Integer roleId);
}