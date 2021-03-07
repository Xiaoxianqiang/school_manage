package com.halfsummer.management.arrangements.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.util.UuidUtil;
import com.halfsummer.management.arrangements.entity.CourseArrangements;
import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.mapper.CourseArrangementsDemoMapper;
import com.halfsummer.management.arrangements.request.AddArrangementsDemoRequest;
import com.halfsummer.management.arrangements.request.ListArrangementsDemoRequest;
import com.halfsummer.management.arrangements.request.UpdateArrangementsDemoRequest;
import com.halfsummer.management.arrangements.service.CourseArrangementsDemoService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseArrangementsDemoServiceImpl implements CourseArrangementsDemoService {
    @Autowired
    private CourseArrangementsDemoMapper courseArrangementsDemoMapper;
    @Override
    public CourseArrangementsDemo getById(String id) {
        return courseArrangementsDemoMapper.getById(id);
    }

    @Override
    public int add(AddArrangementsDemoRequest questionnaire) {
        CourseArrangementsDemo courseArrangementsDemo = new CourseArrangementsDemo();
        BeanUtils.copyProperties(questionnaire, courseArrangementsDemo);
        courseArrangementsDemo.setId(UuidUtil.getUUID());
        return courseArrangementsDemoMapper.insert(courseArrangementsDemo);
    }

    @Override
    public PageInfo<CourseArrangementsDemo> list(ListArrangementsDemoRequest questionnaire) {
        PageHelper.startPage(questionnaire.getPageNum(), questionnaire.getPageSize());
        List<CourseArrangementsDemo> list = courseArrangementsDemoMapper.list(questionnaire);
        PageInfo<CourseArrangementsDemo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int delete(String id) {
        return courseArrangementsDemoMapper.delete(id);
    }

    @Override
    public int update(UpdateArrangementsDemoRequest questionnaire) {
        CourseArrangementsDemo courseArrangementsDemo = courseArrangementsDemoMapper.getById(questionnaire.getId());
        courseArrangementsDemo.setUrl(questionnaire.getUrl());
        return courseArrangementsDemoMapper.update(courseArrangementsDemo);
    }
}
