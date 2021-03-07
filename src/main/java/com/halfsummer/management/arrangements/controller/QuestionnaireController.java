package com.halfsummer.management.arrangements.controller;

import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.arrangements.entity.Questionnaire;
import com.halfsummer.management.arrangements.request.*;
import com.halfsummer.management.arrangements.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultInfo add(@RequestBody AddQuestionnaireRequest questionnaire){
        questionnaireService.add(questionnaire);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/query")
    @ResponseBody
    public ResultInfo add(@RequestBody QueryQuestionnaireRequest questionnaire){
        Questionnaire byId = questionnaireService.getById(questionnaire.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),byId);
    }
    @RequestMapping("/list")
    @ResponseBody
    public ResultInfo list(@RequestBody ListQuestionnaireRequest questionnaire){
        PageInfo<Questionnaire> list = questionnaireService.list(questionnaire);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),list);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultInfo update(@RequestBody UpdateQuestionnaireRequest questionnaire){
        int add = questionnaireService.update(questionnaire);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo add(@RequestBody deleteQuestionnaireRequest questionnaire){
        int delete = questionnaireService.delete(questionnaire.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
}
