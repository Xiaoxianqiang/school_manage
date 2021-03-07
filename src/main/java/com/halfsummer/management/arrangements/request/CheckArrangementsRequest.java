package com.halfsummer.management.arrangements.request;

public class CheckArrangementsRequest {
    private String id;

    /** 老师建议 */
    private String suggest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }
}
