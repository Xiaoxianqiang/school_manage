package com.halfsummer.management.arrangements.service;

import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.entity.Questionnaire;
import com.halfsummer.management.arrangements.request.*;

import java.util.List;

public interface CourseArrangementsDemoService {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    CourseArrangementsDemo getById(String id);

    /**
     * 添加问卷
     * @param questionnaire
     * @return
     */
    int add(AddArrangementsDemoRequest questionnaire);

    /**
     * 查询集合
     * @param questionnaire
     * @return
     */
    List<CourseArrangementsDemo> list(ListArrangementsDemoRequest questionnaire);

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
    int update(UpdateArrangementsDemoRequest questionnaire);
}
