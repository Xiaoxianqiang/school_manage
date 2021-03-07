package com.halfsummer.management.arrangements.request;

public class AddArrangementsDemoRequest {

    /** 辅导员用户ID */
    private String userId;

    /** 管理模板下载路径 */
    private String url;

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
}
