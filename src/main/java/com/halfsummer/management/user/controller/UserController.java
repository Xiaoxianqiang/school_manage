package com.halfsummer.management.user.controller;

import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.user.entity.User;
import com.halfsummer.management.user.request.*;
import com.halfsummer.management.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultInfo login(@RequestBody LogUserRequest user, HttpServletRequest request){
        String code = request.getSession().getAttribute("code").toString();
        if(code==null){
            return new ResultInfo(CommonEnum.PARAM_EMPTY.getResultCode(),
                    "code:" +CommonEnum.PARAM_EMPTY.getResultMsg());
        }
        if(!code.equals(user.getCode())){
            return new ResultInfo(CommonEnum.CAPTCHA_ERROR.getResultCode(),
                    "code:" +CommonEnum.CAPTCHA_ERROR.getResultMsg());
        }
        ResultInfo login = userService.login(user);
        request.getSession().setAttribute("user",login.getData());
        return login;

    }
    /**
     * 新增
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public ResultInfo add(@RequestBody QueryUserRequest user, HttpServletRequest request){
        User byId = userService.getById(user.getId());

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),byId);
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultInfo add(@RequestBody AddUserRequest user, HttpServletRequest request){
        String code = request.getSession().getAttribute("code").toString();
        if(code==null){
            return new ResultInfo(CommonEnum.PARAM_EMPTY.getResultCode(),
                    "code:" +CommonEnum.PARAM_EMPTY.getResultMsg());
        }
        if(!code.equals(user.getCode())){
            return new ResultInfo(CommonEnum.CAPTCHA_ERROR.getResultCode(),
                    "code:" +CommonEnum.CAPTCHA_ERROR.getResultMsg());
        }
        int add = userService.add(user);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultInfo update(@RequestBody UpdateUserRequest user){
        int add = userService.update(user);
        if(add!=1){
            //TODO 修改失败
        }
        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg());
    }
    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultInfo list(@RequestBody ListUserRequest user){
        PageInfo<User> list = userService.list(user);

        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),list);
    }
}
