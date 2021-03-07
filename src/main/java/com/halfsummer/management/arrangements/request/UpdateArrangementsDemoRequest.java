package com.halfsummer.management.arrangements.request;

public class UpdateArrangementsDemoRequest {
    /** ID */
    private String id;

    /** 管理模板下载路径 */
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
