package com.halfsummer.management.user.service.impl;

import com.halfsummer.baseframework.util.UuidUtil;
import com.halfsummer.management.user.entity.User;
import com.halfsummer.management.user.mapper.UserMapper;
import com.halfsummer.management.user.request.AddUserRequest;
import com.halfsummer.management.user.request.ListUserRequest;
import com.halfsummer.management.user.request.LogUserRequest;
import com.halfsummer.management.user.request.UpdateUserRequest;
import com.halfsummer.management.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LogUserRequest user) {
        User user1 = userMapper.getByNo(user.getUserNo());
        if(user1==null){
            //TODO 没有该账户
        }
        if(!user1.getPassword().equals(user.getPassword())){
            //TODO 密码错误
        }
        return user1;
    }

    @Override
    public User getById(String userId) {
        return userMapper.getById(userId);
    }

    @Override
    public List<User> list(ListUserRequest user) {
        return userMapper.list(user);
    }

    @Override
    public int add(AddUserRequest user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setId(UuidUtil.getUUID());
        user1.setUserNo(UuidUtil.getUUID());
        return userMapper.insert(user1);
    }

    @Override
    public int update(UpdateUserRequest user) {
        User user1 = getById(user.getId());
        user1.setName(user.getName());
        user1.setClassGrade(user.getClassGrade());
        user1.setGender(user.getGender());
        user1.setPassword(user.getPassword());
        return userMapper.update(user1);
    }

    @Override
    public int delete(String userId) {
        User user = new User();
        user.setId(userId);
        return userMapper.delete(user);
    }
}
