package com.fendi.ttclub.service;

import com.fendi.ttclub.entity.Right;

import java.util.List;

public interface RightService {
    /**
     * 查询全部权限列表
     * @return
     */
    List<Right> getRightList(Right right);

    int saveRight(Right right);

    Right getRightById(Integer trId);

    int editRight(Right right);
}
