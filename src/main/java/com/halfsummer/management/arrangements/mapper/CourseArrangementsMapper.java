package com.halfsummer.management.arrangements.mapper;

import com.github.pagehelper.Page;
import com.halfsummer.management.arrangements.entity.CourseArrangements;
import com.halfsummer.management.arrangements.entity.CourseArrangementsDemo;
import com.halfsummer.management.arrangements.request.CheckArrangementsRequest;
import com.halfsummer.management.arrangements.request.ListArrangementsDemoRequest;
import com.halfsummer.management.arrangements.request.ListArrangementsRequest;
import com.halfsummer.management.arrangements.request.TodayArrangementsRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CourseArrangementsMapper {

    /**
     * 根据ID查询
     * @param Id
     * @return
     */
    CourseArrangements getById(String Id);

    /**
     * 添加模板
     * @param courseArrangements
     * @return
     */
    int insert(CourseArrangements courseArrangements);

    /**
     * 今日提交
     * @param arrangements
     * @return
     */
    int today(TodayArrangementsRequest arrangements);

    /**
     * 删除模板
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改模板
     * @param courseArrangements
     * @return
     */
    int update(CourseArrangements courseArrangements);

    /**
     * 获取集合
     * @param listRequest
     * @return
     */
    List<CourseArrangements> list(ListArrangementsRequest listRequest);


}
