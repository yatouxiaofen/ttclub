package com.fendi.ttclub.controller.system;

import com.fendi.ttclub.bean.ResponseBean;
import com.fendi.ttclub.constant.TTClubConstant;
import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.User;
import com.fendi.ttclub.service.RightService;
import com.fendi.ttclub.service.UserService;
import com.fendi.ttclub.util.ResponseBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RightService rightService;

    @RequestMapping("/getUserById")
    @ResponseBody
    public ResponseBean getUserById(Integer id){
        if(id==null){
            return ResponseBeanUtil.fail("查询失败，用户编号为空！");
        }
        LOGGER.info("查询用户编号："+id+"的用户信息。");
        User user = userService.getUserById(id);
        return ResponseBeanUtil.success(user);
    }

    @RequestMapping("getUserRights")
    @ResponseBody
    public ResponseBean getUserRights(HttpSession session){
        User user = (User)session.getAttribute(TTClubConstant.LOGIN_USER);
        List<Right> rightList = null;
        if(user.getHasSuperRight()!=0){
            rightList = rightService.getRightList(null);
        }else{
            rightList = userService.getUserRightList(user);
        }
        return ResponseBeanUtil.success(rightList);
    }
}
