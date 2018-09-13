package com.fendi.ttclub.service.impl.website;

import com.fendi.ttclub.dao.website.TimeLineMapper;
import com.fendi.ttclub.entity.website.TimeLine;
import com.fendi.ttclub.service.website.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("timelineService")
public class TimeLineServiceImpl implements TimelineService {

    @Autowired
    private TimeLineMapper timeLineMapper;

    @Override
    public List<TimeLine> getList(TimeLine timeLine) {
        return timeLineMapper.selectList(timeLine);
    }

    @Override
    public int save(TimeLine timeLine) {
        return timeLineMapper.insert(timeLine);
    }

    @Override
    public TimeLine getById(Integer id) {
        return timeLineMapper.selectByPrimaryKey(id);
    }

    @Override
    public int edit(TimeLine timeLine) {
        return timeLineMapper.updateByPrimaryKey(timeLine);
    }

    @Override
    public int delete(Integer id) {
        return timeLineMapper.deleteByPrimaryKey(id);
    }
}
