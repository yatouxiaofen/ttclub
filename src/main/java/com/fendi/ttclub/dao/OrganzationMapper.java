package com.fendi.ttclub.dao;

import com.fendi.ttclub.entity.Organzation;

public interface OrganzationMapper {
    int deleteByPrimaryKey(String toId);

    int insert(Organzation record);

    int insertSelective(Organzation record);

    Organzation selectByPrimaryKey(String toId);

    int updateByPrimaryKeySelective(Organzation record);

    int updateByPrimaryKey(Organzation record);
}