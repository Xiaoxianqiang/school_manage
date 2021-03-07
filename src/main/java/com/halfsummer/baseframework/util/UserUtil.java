package com.halfsummer.baseframework.util;

import com.halfsummer.baseframework.vo.LoginUserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author BestClever
 * @title: UserUtil
 * @projectName book-manage
 * @description: TODO
 * @date 2020-11-04 10:56
 */
public class UserUtil {

    public static LoginUserVo getCurrentUser(HttpServletRequest request){
        LoginUserVo loginUser = (LoginUserVo) request.getSession().getAttribute("loginUser");
        return loginUser;
    }
}
