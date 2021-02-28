package com.halfsummer.management.user.mapper;

import com.halfsummer.management.user.entity.User;
import com.halfsummer.management.user.request.ListUserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    User getById(String id);

    /**
     * 根据账号获取用户信息
     * @param userNo
     * @return
     */
    User getByNo(String userNo);

    /**
     * 新建用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int delete(User user);

    /**
     * 获取用户集合
     * @param user
     * @return
     */
    List<User> list(ListUserRequest user);
}
