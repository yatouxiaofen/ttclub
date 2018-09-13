package com.fendi.ttclub.service.impl;

import com.fendi.ttclub.dao.RightMapper;
import com.fendi.ttclub.dao.RoleMapper;
import com.fendi.ttclub.dao.RoleRightMapper;
import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.Role;
import com.fendi.ttclub.entity.RoleRight;
import com.fendi.ttclub.exception.ParameterValidateException;
import com.fendi.ttclub.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang.StringUtils.right;
import static org.apache.commons.lang.StringUtils.split;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RightMapper rightMapper;

    @Autowired
    private RoleRightMapper roleRightMapper;

    @Override
    public List<Role> getRoleList() {
        return roleMapper.selectRoleList();
    }

    @Override
    public List<Right> getRoleRightList(Integer roleId) throws Exception{
        if(roleId==null){
            throw new ParameterValidateException("权限编号不能为空");
        }
        return rightMapper.selectRoleRightList(roleId);
    }

    @Override
    public boolean putRoleRights(Integer roleId, String rightIds) {
        roleRightMapper.deleteByRoleId(roleId);
        String[] ids = rightIds.split(",");
        for (String rightId:ids) {
            RoleRight roleRight = new RoleRight();
            roleRight.setRoleId(roleId);
            roleRight.setRightId(Integer.parseInt(rightId));
            roleRightMapper.insert(roleRight);
        }
        return true;
    }
}
