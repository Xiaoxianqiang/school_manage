package com.halfsummer.management.arrangements.controller;

import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.entity.Questionnaire;
import com.halfsummer.management.arrangements.request.*;
import com.halfsummer.management.arrangements.service.CourseArrangementsDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/arrangements/demo")
public class CourseArrangementsDemoController {
    @Autowired
    private CourseArrangementsDemoService courseArrangementsDemoService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultInfo add(@RequestBody AddArrangementsDemoRequest arrangementsDemo){
        courseArrangementsDemoService.add(arrangementsDemo);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/query")
    @ResponseBody
    public ResultInfo add(@RequestBody QueryArrangementsDemoRequest arrangementsDemo){
        CourseArrangementsDemo byId = courseArrangementsDemoService.getById(arrangementsDemo.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),byId);
    }
    @RequestMapping("/list")
    @ResponseBody
    public ResultInfo list(@RequestBody ListArrangementsDemoRequest arrangementsDemo){
        List<CourseArrangementsDemo> list = courseArrangementsDemoService.list(arrangementsDemo);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),list);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultInfo update(@RequestBody UpdateArrangementsDemoRequest arrangementsDemo){
        int add = courseArrangementsDemoService.update(arrangementsDemo);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo add(@RequestBody deleteArrangementsDemoRequest arrangementsDemo){
        int delete = courseArrangementsDemoService.delete(arrangementsDemo.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
}
