package com.fendi.ttclub.controller.system;

import com.fendi.ttclub.bean.EasyUITree;
import com.fendi.ttclub.bean.ResponseBean;
import com.fendi.ttclub.constant.TTClubConstant;
import com.fendi.ttclub.entity.Right;
import com.fendi.ttclub.entity.User;
import com.fendi.ttclub.service.RightService;
import com.fendi.ttclub.util.MenuUtil;
import com.fendi.ttclub.util.ResponseBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/right")
public class RightController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RightController.class);

    @Autowired
    private RightService rightService;

    @RequestMapping("/index")
    public String index(){
        return "right/list";
    }

    @RequestMapping("/getRightList")
    @ResponseBody
    public List<Right> getRightList(Right right){
        List<Right> rights = rightService.getRightList(right);
        return rights;
    }

    /**
     * 查询权限菜单  admin用户登录查询全量菜单使用
     * @return
     */
    @RequestMapping("/getRightMenu")
    @ResponseBody
    public ResponseBean getRightMenu(String rightName){
        Right right = new Right();
        right.setRightName(rightName);
        List<Right> rights = rightService.getRightList(right);
        return ResponseBeanUtil.success(rights);
    }

    @RequestMapping("/rightTree")
    @ResponseBody
    public List<EasyUITree> rightTree(Right right){
        try {
            List<Right> rightList = rightService.getRightList(right);
            Right rootRight = new Right();
            rootRight.setTrId(0);
            rootRight.setRightName("父级权限");
            rootRight.setChildren(rightList);
            List<Right> rights = new ArrayList<Right>(1);
            rights.add(rootRight);
            List<EasyUITree> easyUITrees = MenuUtil.reverseMenus(rights);
            return easyUITrees;
        }catch (Exception e){
            LOGGER.error("查询权限信息出错！", e);
            return null;
        }
    }

    @RequestMapping("/toAddRight")
    public String toAddRight(){
        return "right/add";
    }

    @RequestMapping("/addRight")
    @ResponseBody
    public ResponseBean addRight(Right right){
        LOGGER.info(right.toString());
        int count = rightService.saveRight(right);
        return ResponseBeanUtil.success("操作成功");
    }

    @RequestMapping("/toEditRight")
    public String toEditRight(Integer trId){
        if(trId==null){
            //return ResponseBeanUtil.fail("操作失败！权限ID为空！");
        }
        Right right = rightService.getRightById(trId);
        return "right/edit";
    }

    @RequestMapping("/editRight")
    @ResponseBody
    public ResponseBean editRight(Right right){
        LOGGER.info(right.toString());
        int count = rightService.editRight(right);
        return ResponseBeanUtil.success("操作成功");
    }
}
