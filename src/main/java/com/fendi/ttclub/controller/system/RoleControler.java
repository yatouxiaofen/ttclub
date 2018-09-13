package com.fendi.ttclub.controller.system;

import com.alibaba.fastjson.JSON;
import com.fendi.ttclub.bean.EasyUITree;
import com.fendi.ttclub.bean.ResponseBean;
import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.Role;
import com.fendi.ttclub.service.RoleService;
import com.fendi.ttclub.util.MenuUtil;
import com.fendi.ttclub.util.ResponseBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleControler.class);

    @Autowired
    private RoleService roleService;

    /**
     * 跳转界面，jsp通过html中的data-options属性获取后台角色列表数据
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        return "role/list";
    }

    /**
     * 后台model中返回角色列表，jsp通过jstl进行数据显示
     * @param model
     * @return
     */
    @RequestMapping("/indexWithResponse")
    public String indexWithResponse(Model model){
        List<Role> roleList = roleService.getRoleList();
        model.addAttribute("roleList", roleList);
        return "role/listWithResponse";
    }

    /**
     * 跳转界面，jsp通过datagrid获取后台角色列表数据
     * @param model
     * @return
     */
    @RequestMapping("/indexWithJs")
    public String indexWithJs(Model model){
        return "role/listWithJs";
    }

    @RequestMapping("/getRoleList")
    @ResponseBody
    public List<Role> getRoleList(){
        List<Role> roleList = roleService.getRoleList();
        return roleList;
    }

    /**
     * dialog方式弹出角色权限列表
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping("/getRoleRightList")
    public String getRoleRightList(Integer roleId,Model model){
        model.addAttribute("roleId", roleId);
        return "role/roleRightList";
    }

    /**
     * tab子界面方式显示角色权限列表，与dialog方式相比，需要重新引入jquery和jquery-easyui的js文件
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping("/getRoleRightList1")
    public String getRoleRightList1(Integer roleId,Model model){
        model.addAttribute("roleId", roleId);
        return "role/roleRightList1";
    }

    @RequestMapping("/roleRightList")
    @ResponseBody
    public List<EasyUITree> roleRightList(Integer roleId,Model model){
        try {
            List<Right> roleRightList = roleService.getRoleRightList(roleId);
            List<EasyUITree> easyUITrees = MenuUtil.reverseMenus(roleRightList);
            return easyUITrees;
        }catch (Exception e){
            LOGGER.error("查询角色权限信息出错！", e);
            return null;
        }
    }

    @RequestMapping("/putRoleRights")
    @ResponseBody
    public ResponseBean roleRights(Integer roleId,String rightIds){
        boolean isSuccess = roleService.putRoleRights(roleId,rightIds);
        return ResponseBeanUtil.success("操作成功");
    }

}
