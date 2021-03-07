package com.halfsummer.management.user.entity;

/**
 * 角色表
 */
public class Role {

    /** 角色ID */
    private String id;

    /** 角色名称 */
    private String name;

    /** 创建时间 */
    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
