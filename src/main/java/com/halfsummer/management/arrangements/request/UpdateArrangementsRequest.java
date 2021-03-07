package com.halfsummer.management.arrangements.request;

public class UpdateArrangementsRequest {
    private String id;
    private String plan;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
