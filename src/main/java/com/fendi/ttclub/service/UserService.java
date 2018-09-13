package com.fendi.ttclub.service;

import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    User getUserByName(User user);

    List<Right> getUserRightList(User user);
}
