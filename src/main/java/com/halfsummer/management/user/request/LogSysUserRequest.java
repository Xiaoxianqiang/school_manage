package com.halfsummer.management.user.request;

public class LogSysUserRequest {
    /** 验证码 */
    private String code;

    /** 管理员名称 */
    private String name;

    /** 密码 */
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
