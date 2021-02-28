package com.halfsummer.management.arrangements.mapper;

import com.halfsummer.management.arrangements.entity.CourseArrangements;
import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.entity.Questionnaire;
import com.halfsummer.management.arrangements.request.ListArrangementsDemoRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseArrangementsDemoMapper {
    /**
     * 根据ID查询
     * @param Id
     * @return
     */
    CourseArrangementsDemo getById(String Id);

    /**
     * 添加模板
     * @param courseArrangementsDemo
     * @return
     */
    int insert(CourseArrangementsDemo courseArrangementsDemo);

    /**
     * 删除模板
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改模板
     * @param courseArrangementsDemo
     * @return
     */
    int update(CourseArrangementsDemo courseArrangementsDemo);

    /**
     * 获取集合
     * @param listRequest
     * @return
     */
    List<CourseArrangementsDemo> list(ListArrangementsDemoRequest listRequest);
}
