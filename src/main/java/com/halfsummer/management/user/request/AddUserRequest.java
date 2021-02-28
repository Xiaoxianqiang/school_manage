package com.halfsummer.management.user.request;

import java.util.Date;

public class AddUserRequest {

    /** 验证码 */
    private String code;

    /** 姓名 */
    private String name;

    /** 密码 */
    private String password;

    /** 性别 */
    private String gender;

    /** 角色ID */
    private String roleId;

    /** 班级 */
    private String classGrade;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }
}
