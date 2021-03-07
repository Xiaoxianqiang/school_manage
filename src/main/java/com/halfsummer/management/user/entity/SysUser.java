package com.halfsummer.management.user.entity;

import java.util.Date;

/**
 * 管理员账号表
 */
public class SysUser {

    /** ID */
    private String id;

    /** 账号姓名 */
    private String name;

    /** 密码 */
    private String password;

    /** 角色ID */
    private String roleId;

    /** 创建时间 */
    private Date createTime;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
