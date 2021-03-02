package com.halfsummer.management.arrangements.service;

import com.github.pagehelper.PageInfo;
import com.halfsummer.management.arrangements.entity.Questionnaire;
import com.halfsummer.management.arrangements.request.AddQuestionnaireRequest;
import com.halfsummer.management.arrangements.request.ListQuestionnaireRequest;
import com.halfsummer.management.arrangements.request.UpdateQuestionnaireRequest;

import java.util.List;

public interface QuestionnaireService {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Questionnaire getById(String id);
    /**
     * 添加问卷
     * @param questionnaire
     * @return
     */
    int add(AddQuestionnaireRequest questionnaire);

    /**
     * 查询集合
     * @param questionnaire
     * @return
     */
    PageInfo<Questionnaire> list(ListQuestionnaireRequest questionnaire);

    /**
     * 删除问卷
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改问卷
     * @param questionnaire
     * @return
     */
    int update(UpdateQuestionnaireRequest questionnaire);
}
