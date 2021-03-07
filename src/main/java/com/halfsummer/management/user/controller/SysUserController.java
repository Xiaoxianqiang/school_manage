package com.halfsummer.management.user.controller;

import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.user.entity.SysUser;
import com.halfsummer.management.user.entity.User;
import com.halfsummer.management.user.request.LogSysUserRequest;
import com.halfsummer.management.user.request.LogUserRequest;
import com.halfsummer.management.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultInfo login(@RequestBody LogSysUserRequest user, HttpServletRequest request){
        String code = request.getSession().getAttribute("code").toString();
        if(code==null){
            return new ResultInfo(CommonEnum.PARAM_EMPTY.getResultCode(),
                    "code:" +CommonEnum.PARAM_EMPTY.getResultMsg());
        }
        if(!code.equals(user.getCode())){
            return new ResultInfo(CommonEnum.CAPTCHA_ERROR.getResultCode(),
                    "code:" +CommonEnum.CAPTCHA_ERROR.getResultMsg());
        }
        ResultInfo login = sysUserService.login(user);
        request.getSession().setAttribute("user",login.getData());
        return login;

}
}
