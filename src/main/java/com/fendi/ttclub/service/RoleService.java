package com.fendi.ttclub.service;

import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();

    /**
     * 根据角色ID查询角色权限列表
     * @param roleId
     * @return
     */
    List<Right> getRoleRightList(Integer roleId) throws Exception;

    boolean putRoleRights(Integer roleId, String rightIds);
}
