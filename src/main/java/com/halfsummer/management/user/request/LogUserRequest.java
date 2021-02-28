package com.halfsummer.management.user.request;

public class LogUserRequest {
    /** 验证码 */
    private String code;

    /** 账户 */
    private String userNo;

    /** 密码 */
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
