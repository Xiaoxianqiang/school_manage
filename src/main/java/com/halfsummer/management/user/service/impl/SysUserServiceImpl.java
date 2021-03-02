package com.halfsummer.management.user.service.impl;

import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.user.entity.SysUser;
import com.halfsummer.management.user.mapper.SysUserMapper;
import com.halfsummer.management.user.request.LogSysUserRequest;
import com.halfsummer.management.user.service.SysUserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResultInfo login(LogSysUserRequest user) {
        SysUser byName = sysUserMapper.getByName(user.getName());
        if(byName==null){
            return new ResultInfo(CommonEnum.DATA_NOT_EXIST.getResultCode(),
                    CommonEnum.DATA_NOT_EXIST.getResultMsg());
        }
        if(byName.getPassword().equals(user.getPassword())){
            return new ResultInfo(CommonEnum.PWD_ERROR.getResultCode(),
                    CommonEnum.PWD_ERROR.getResultMsg());
        }
        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),byName);
    }
}
