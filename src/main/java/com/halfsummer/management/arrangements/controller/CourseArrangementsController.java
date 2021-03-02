package com.halfsummer.management.arrangements.controller;

import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.arrangements.entity.CourseArrangements;
import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.request.*;
import com.halfsummer.management.arrangements.service.CourseArrangementsDemoService;
import com.halfsummer.management.arrangements.service.CourseArrangementsService;
import com.halfsummer.management.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/arrangements")
public class CourseArrangementsController {
    @Autowired
    private CourseArrangementsService courseArrangementsService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultInfo add(@RequestBody AddArrangementsRequest arrangements,
                          HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        arrangements.setUserId(user.getId());
        courseArrangementsService.add(arrangements);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/query")
    @ResponseBody
    public ResultInfo add(@RequestBody QueryArrangementsRequest arrangements){
        CourseArrangements byId = courseArrangementsService.getById(arrangements.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),byId);
    }
    @RequestMapping("/check")
    @ResponseBody
    public ResultInfo check(@RequestBody CheckArrangementsRequest arrangements){
        courseArrangementsService.check(arrangements);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/complete")
    @ResponseBody
    public ResultInfo complete(@RequestBody CompleteArrangementsRequest arrangements){
        courseArrangementsService.complete(arrangements);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/list")
    @ResponseBody
    public ResultInfo list(@RequestBody ListArrangementsRequest arrangements){
        PageInfo<CourseArrangements> list = courseArrangementsService.list(arrangements);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),list);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultInfo update(@RequestBody UpdateArrangementsRequest arrangements){
        int add = courseArrangementsService.update(arrangements);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo add(@RequestBody deleteArrangementsRequest arrangementsDemo){
        int delete = courseArrangementsService.delete(arrangementsDemo.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
}
