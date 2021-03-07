package com.halfsummer.management.arrangements.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.util.UuidUtil;
import com.halfsummer.management.arrangements.entity.CourseArrangements;
import com.halfsummer.management.arrangements.mapper.CourseArrangementsMapper;
import com.halfsummer.management.arrangements.request.*;
import com.halfsummer.management.arrangements.service.CourseArrangementsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseArrangementsServiceImpl implements CourseArrangementsService {
    @Autowired
    private CourseArrangementsMapper courseArrangementsMapper;
    @Override
    public CourseArrangements getById(String id) {
        return courseArrangementsMapper.getById(id);
    }

    @Override
    public int add(AddArrangementsRequest questionnaire) {
        CourseArrangements courseArrangements = new CourseArrangements();
        BeanUtils.copyProperties(questionnaire, courseArrangements);
        courseArrangements.setId(UuidUtil.getUUID());
        courseArrangements.setIsCheck("F");
        courseArrangements.setIsComplete("F");
        return courseArrangementsMapper.insert(courseArrangements);
    }

    @Override
    public PageInfo<CourseArrangements> list(ListArrangementsRequest questionnaire) {
        PageHelper.startPage(questionnaire.getPageNum(), questionnaire.getPageSize());
        List<CourseArrangements> list = courseArrangementsMapper.list(questionnaire);
        PageInfo<CourseArrangements> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean today(TodayArrangementsRequest arrangements) {
        return courseArrangementsMapper.today(arrangements)>0;
    }

    @Override
    public int delete(String id) {
        return courseArrangementsMapper.delete(id);
    }

    @Override
    public int update(UpdateArrangementsRequest arrangements) {
        CourseArrangements byId = courseArrangementsMapper.getById(arrangements.getId());
        byId.setPlan(arrangements.getPlan());
        return courseArrangementsMapper.update(byId);
    }

    @Override
    public void check(CheckArrangementsRequest arrangements) {
        CourseArrangements byId = courseArrangementsMapper.getById(arrangements.getId());
        byId.setIsCheck("T");
        byId.setSuggest(arrangements.getSuggest());
        courseArrangementsMapper.update(byId);
    }

    @Override
    public void complete(CompleteArrangementsRequest arrangements) {
        CourseArrangements byId = courseArrangementsMapper.getById(arrangements.getId());
        byId.setIsComplete("T");
        courseArrangementsMapper.update(byId);
    }
}
