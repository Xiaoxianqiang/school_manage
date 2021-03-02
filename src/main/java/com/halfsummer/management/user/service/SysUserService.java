package com.halfsummer.management.user.service;

import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.user.entity.SysUser;
import com.halfsummer.management.user.request.LogSysUserRequest;

public interface SysUserService {

    ResultInfo login(LogSysUserRequest user);
}
