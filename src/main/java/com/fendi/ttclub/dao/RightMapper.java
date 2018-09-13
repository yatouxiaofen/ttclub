package com.fendi.ttclub.dao;

import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RightMapper {
    int deleteByPrimaryKey(Integer trId);

    int insert(Right record);

    int insertSelective(Right record);

    Right selectByPrimaryKey(Integer trId);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);

    List<Right> selectRightList(Map<String,Object> map);

    List<Right> selectRoleRightList(@Param("roId") Integer roId);

    /**
     * 根据用户查询用户权限
     * @param map
     * @return
     */
    List<Right> selectUserRightList(Map<String,Object> map);
}