package com.halfsummer.management.user.request;

public class UpdateUserRequest {
    /** ID */
    private String id;

    /** 姓名 */
    private String name;

    /** 密码 */
    private String password;

    /** 性别 */
    private String gender;

    /** 班级 */
    private String classGrade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }
}
