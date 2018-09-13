package com.fendi.ttclub.dao.website;

import com.fendi.ttclub.entity.website.TimeLine;

import java.util.List;

public interface TimeLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TimeLine record);

    int insertSelective(TimeLine record);

    TimeLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TimeLine record);

    int updateByPrimaryKey(TimeLine record);

    List<TimeLine> selectList(TimeLine timeLine);
}