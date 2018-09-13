package com.fendi.ttclub.service.impl;

import com.fendi.ttclub.dao.RightMapper;
import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.service.RightService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("rightService")
public class RightServiceImpl implements RightService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RightServiceImpl.class);

    @Autowired
    private RightMapper rightMapper;

    @Override
    public List<Right> getRightList(Right right) {
        Map<String,Object> map = new HashMap<String, Object>();
        if(right!=null) {
            if (!StringUtils.isEmpty(right.getRightName())) {
                map.put("rightName", right.getRightName());
            }
        }
        return rightMapper.selectRightList(map);
    }

    @Override
    public int saveRight(Right right) {
        return rightMapper.insert(right);
    }

    @Override
    public Right getRightById(Integer trId) {
        return rightMapper.selectByPrimaryKey(trId);
    }

    @Override
    public int editRight(Right right) {
        return rightMapper.updateByPrimaryKeySelective(right);
    }
}
