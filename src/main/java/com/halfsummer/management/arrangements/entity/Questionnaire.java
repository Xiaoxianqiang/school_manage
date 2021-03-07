package com.halfsummer.management.arrangements.entity;

import java.util.Date;

public class Questionnaire {
    private String id;
    private String userId;
    private String title1;
    private String title2;
    private String title3;
    private String title4;
    private String title5;
    private String title6;
    private String title7;
    private Date createTime;

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

    public String gettitle1() {
        return title1;
    }

    public void settitle1(String title1) {
        this.title1 = title1;
    }

    public String gettitle2() {
        return title2;
    }

    public void settitle2(String title2) {
        this.title2 = title2;
    }

    public String gettitle3() {
        return title3;
    }

    public void settitle3(String title3) {
        this.title3 = title3;
    }

    public String gettitle4() {
        return title4;
    }

    public void settitle4(String title4) {
        this.title4 = title4;
    }

    public String gettitle5() {
        return title5;
    }

    public void settitle5(String title5) {
        this.title5 = title5;
    }

    public String gettitle6() {
        return title6;
    }

    public void settitle6(String title6) {
        this.title6 = title6;
    }

    public String gettitle7() {
        return title7;
    }

    public void settitle7(String title7) {
        this.title7 = title7;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
