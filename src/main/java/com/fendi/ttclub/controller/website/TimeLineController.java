package com.fendi.ttclub.controller.website;

import com.fendi.ttclub.bean.ResponseBean;
import com.fendi.ttclub.entity.website.TimeLine;
import com.fendi.ttclub.service.website.TimelineService;
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
@RequestMapping("/timeline")
public class TimeLineController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TimeLineController.class);

    @Autowired
    private TimelineService timelineService;

    @RequestMapping("/index")
    public String index(TimeLine timeLine){
        return "website/timeline/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<TimeLine> getList(TimeLine timeLine){
        List<TimeLine> timeLines = timelineService.getList(timeLine);
        return timeLines;
    }

    @RequestMapping("/toSave")
    public String toSave(TimeLine timeLine){
        return "website/timeline/add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResponseBean save(TimeLine timeLine){
        int count = timelineService.save(timeLine);
        if (count<=0){
            return ResponseBeanUtil.fail("添加失败！");
        }
        return ResponseBeanUtil.success("添加成功！");
    }

    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Model model){
        TimeLine timeLine = timelineService.getById(id);
        model.addAttribute("timeline", timeLine);
        return "website/timeline/edit";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResponseBean edit(TimeLine timeLine){
        int count = timelineService.edit(timeLine);
        if (count <= 0)
        {
            return ResponseBeanUtil.fail("修改失败！");
        }
        return ResponseBeanUtil.success("修改成功！");
    }

    @RequestMapping("/remove")
    @ResponseBody
    public ResponseBean delete(Integer id){
        int count = timelineService.delete(id);
        if(count<=0){
            return ResponseBeanUtil.fail("删除失败！ ");
        }
        return ResponseBeanUtil.success("删除成功！");
    }

}
