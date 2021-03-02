package com.halfsummer.management.arrangements.service;

import com.github.pagehelper.PageInfo;
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
     * 添加模板
     * @param questionnaire
     * @return
     */
    int add(AddArrangementsDemoRequest questionnaire);

    /**
     * 查询集合
     * @param questionnaire
     * @return
     */
    PageInfo<CourseArrangementsDemo> list(ListArrangementsDemoRequest questionnaire);

    /**
     * 删除模板
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改模板
     * @param questionnaire
     * @return
     */
    int update(UpdateArrangementsDemoRequest questionnaire);
}
