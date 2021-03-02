package com.halfsummer.management.arrangements.service;

import com.github.pagehelper.PageInfo;
import com.halfsummer.management.arrangements.entity.CourseArrangements;
import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.request.*;

import java.util.List;

public interface CourseArrangementsService {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    CourseArrangements getById(String id);

    /**
     * 添加规划
     * @param questionnaire
     * @return
     */
    int add(AddArrangementsRequest questionnaire);

    /**
     * 查询集合
     * @param questionnaire
     * @return
     */
    PageInfo<CourseArrangements> list(ListArrangementsRequest questionnaire);

    /**
     * 删除规划
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改规划
     * @param questionnaire
     * @return
     */
    int update(UpdateArrangementsRequest questionnaire);

    /**
     * 辅导员检查
     * @param arrangements
     */
    void check(CheckArrangementsRequest arrangements);

    /**
     * 完成规划
     * @param arrangements
     */
    void complete(CompleteArrangementsRequest arrangements);
}
