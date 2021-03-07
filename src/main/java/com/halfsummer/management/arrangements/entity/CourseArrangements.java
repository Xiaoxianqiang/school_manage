package com.halfsummer.management.arrangements.entity;

/**
 * 学生每日规划表
 */
public class CourseArrangements {
    /** ID */
    private String id;

    /** 学生用户ID */
    private String userId;

    /** 每日计划 */
    private String plan;

    /** 老师建议 */
    private String suggest;

    /** 辅导员审核T通过、F未通过 */
    private String isCheck;

    /** 是否完成T是、F否 */
    private String isComplete;

    /** 创建时间 */
    private String createTime;

    /** 修改时间*/
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
