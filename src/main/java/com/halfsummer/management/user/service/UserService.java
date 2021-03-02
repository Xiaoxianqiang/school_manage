package com.halfsummer.management.user.service;

import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.user.entity.User;
import com.halfsummer.management.user.request.AddUserRequest;
import com.halfsummer.management.user.request.ListUserRequest;
import com.halfsummer.management.user.request.LogUserRequest;
import com.halfsummer.management.user.request.UpdateUserRequest;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param user
     */
    ResultInfo login(LogUserRequest user);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    User getById(String userId);

    /**
     * 获取集合
     * @param user
     * @return
     */
    PageInfo<User> list(ListUserRequest user);

    /**
     * 新建用户
     * @param user
     * @return
     */
    int add(AddUserRequest user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(UpdateUserRequest user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int delete(String userId);
}
