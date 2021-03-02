package com.halfsummer.management.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.baseframework.util.UuidUtil;
import com.halfsummer.management.arrangements.entity.Questionnaire;
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
    public ResultInfo login(LogUserRequest user) {
        User user1 = userMapper.getByNo(user.getUserNo());
        if(user1==null){
            return new ResultInfo(CommonEnum.DATA_NOT_EXIST.getResultCode(),
                    CommonEnum.DATA_NOT_EXIST.getResultMsg());
        }
        if(user1.getPassword().equals(user.getPassword())){
            return new ResultInfo(CommonEnum.PWD_ERROR.getResultCode(),
                    CommonEnum.PWD_ERROR.getResultMsg());
        }
        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),user1);
    }

    @Override
    public User getById(String userId) {
        return userMapper.getById(userId);
    }

    @Override
    public PageInfo<User> list(ListUserRequest user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<User> list = userMapper.list(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
