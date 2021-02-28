package com.halfsummer.management.arrangements.mapper;

import com.halfsummer.management.arrangements.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionnaireMapper {
    /**
     * 根据ID查询
     * @param Id
     * @return
     */
    Questionnaire getById(String Id);

    /**
     * 添加问卷
     * @param questionnaire
     * @return
     */
    int insert(Questionnaire questionnaire);

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
    int update(Questionnaire questionnaire);

    /**
     * 获取集合
     * @param questionnaire
     * @return
     */
    List<Questionnaire> list(Questionnaire questionnaire);
}
