package com.halfsummer.baseframework.vo;

import lombok.Data;

/**
 * @author BestClever
 * @title: LoginUserVO
 * @projectName book-manage
 * @description: TODO
 * @date 2020-10-31 12:53
 */
@Data
public class LoginUserVo {

    private Integer id;

    private String userName;

    private Integer roleId;

    private String roleName;

}
