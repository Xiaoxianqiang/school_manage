package com.halfsummer.management.user.mapper;

import com.halfsummer.management.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserMapper {

    /**
     * 获取用户信息
     * @param name
     * @return
     */
    SysUser getByName(String name);
}
