package com.fendi.ttclub.service.impl;

import com.fendi.ttclub.dao.RightMapper;
import com.fendi.ttclub.dao.UserMapper;
import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.User;
import com.fendi.ttclub.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RightMapper rightMapper;

    @Override
    public User getUserById(Integer tuId) {
        return userMapper.selectByPrimaryKey(tuId);
    }

    @Override
    public User getUserByName(User user) {
        User loginUser = userMapper.selectByName(user);
        if(loginUser==null||!loginUser.getPassword().equals(user.getPassword())){
            loginUser = null;
        }
        return loginUser;
    }

    @Override
    public List<Right> getUserRightList(User user) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId", user.getTuId());
        return rightMapper.selectUserRightList(map);
    }
}
