package com.halfsummer.management.arrangements.entity;

import java.util.Date;

/**
 * 学生每日规划模板表
 */
public class CourseArrangementsDemo {

    /** ID */
    private String id;

    /** 辅导员用户ID */
    private String userId;

    /** 管理模板下载路径 */
    private String url;

    /** 创建时间 */
    private Date createTime;

    /** 创建时间 */
    private Date updateTime;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
