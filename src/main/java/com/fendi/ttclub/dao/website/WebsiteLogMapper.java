package com.fendi.ttclub.dao.website;

import com.fendi.ttclub.entity.website.WebsiteLog;

public interface WebsiteLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(WebsiteLog record);

    int insertSelective(WebsiteLog record);

    WebsiteLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(WebsiteLog record);

    int updateByPrimaryKey(WebsiteLog record);
}