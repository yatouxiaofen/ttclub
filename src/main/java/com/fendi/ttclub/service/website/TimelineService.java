package com.fendi.ttclub.service.website;

import com.fendi.ttclub.entity.website.TimeLine;
import java.util.List;

public interface TimelineService {
    /**
     * 查询全部时间轴
     * @return
     */
    List<TimeLine> getList(TimeLine timeLine);

    int save(TimeLine timeLine);

    TimeLine getById(Integer id);

    int edit(TimeLine timeLine);

    int delete(Integer id);
}
