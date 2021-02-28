package com.halfsummer.management.arrangements.service.impl;

import com.halfsummer.baseframework.util.UuidUtil;
import com.halfsummer.management.arrangements.entity.Questionnaire;
import com.halfsummer.management.arrangements.mapper.QuestionnaireMapper;
import com.halfsummer.management.arrangements.request.AddQuestionnaireRequest;
import com.halfsummer.management.arrangements.request.ListQuestionnaireRequest;
import com.halfsummer.management.arrangements.request.UpdateQuestionnaireRequest;
import com.halfsummer.management.arrangements.service.QuestionnaireService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public Questionnaire getById(String Id) {
        return questionnaireMapper.getById(Id);
    }

    @Override
    public int add(AddQuestionnaireRequest questionnaire) {
        Questionnaire questionnaire1 = new Questionnaire();
        BeanUtils.copyProperties(questionnaire,questionnaire1);
        questionnaire1.setId(UuidUtil.getUUID());
        questionnaire1.setCreateTime(new Date());
        return questionnaireMapper.insert(questionnaire1);
    }

    @Override
    public List<Questionnaire> list(ListQuestionnaireRequest questionnaire) {
        return null;
    }

    @Override
    public int delete(String id) {
        return questionnaireMapper.delete(id);
    }

    @Override
    public int update(UpdateQuestionnaireRequest questionnaire) {
        Questionnaire questionnaire1 = new Questionnaire();
        BeanUtils.copyProperties(questionnaire, questionnaire1);
        return questionnaireMapper.update(questionnaire1);
    }
}
