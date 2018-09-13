package com.fendi.ttclub.util;

import com.fendi.ttclub.bean.EasyUITree;
import com.fendi.ttclub.entity.Right;

import java.util.*;

public class MenuUtil {
    public static List<Right> getMenu(List<Right> list){
        Map<Integer,Right> map = new HashMap<Integer,Right>();
        for(Right p:list){
            if(p.getParentTrId()==0){
                map.put(p.getParentTrId(), p);
            }
        }
        for(Right p:list){
            if(p.getTrId()==0){
                continue;
            }
            Right right = map.get(p.getTrId());
            right.getChildren().add(p);
        }
        //将菜单装在list里面了。需要排序
        List<Right> menus = new ArrayList<Right>();
        Iterator<Right> iter = map.values().iterator();
        while(iter.hasNext()){
            menus.add(iter.next());
        }

        Collections.sort(menus);
        for(Right sp:menus){
            Collections.sort(sp.getChildren());
        }
        return menus;
    }

    public static List<EasyUITree> reverseMenus(List<Right> roleRightList){
        List<EasyUITree> easyUITrees = null;
        if(roleRightList!=null&&roleRightList.size()>0){
            easyUITrees = new ArrayList<EasyUITree>(roleRightList.size());
            for(Right right:roleRightList){
                easyUITrees.add(getChildTree(right));
            }
        }
        return easyUITrees;
    }

    public static EasyUITree getChildTree(Right right){
        EasyUITree uiTree = new EasyUITree();
        uiTree.setId(right.getTrId());
        uiTree.setText(right.getRightName());
        if(right.getChildren()!=null&&right.getChildren().size()>0){
            for(Right childRight:right.getChildren()){
                uiTree.getChildren().add(getChildTree(childRight));
            }
        }else{
            uiTree.setChecked(right.getRoleId()!=null);
        }
        return uiTree;
    }
}