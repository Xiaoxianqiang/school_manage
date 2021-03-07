package com.halfsummer.management.arrangements.request;

public class AddArrangementsRequest {
    /** 学生用户ID */
    private String userId;

    /** 每日计划 */
    private String plan;

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
}
