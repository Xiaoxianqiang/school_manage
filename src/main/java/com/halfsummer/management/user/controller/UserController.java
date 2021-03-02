package com.halfsummer.management.user.controller;

import com.github.pagehelper.PageInfo;
import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultInfo;
import com.halfsummer.management.user.entity.User;
import com.halfsummer.management.user.request.AddUserRequest;
import com.halfsummer.management.user.request.ListUserRequest;
import com.halfsummer.management.user.request.LogUserRequest;
import com.halfsummer.management.user.request.UpdateUserRequest;
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
            //TODO 判空
        }
        if(!code.equals(user.getCode())){
            //TODO 验证码不一致
        }
        User login = userService.login(user);
        request.getSession().setAttribute("user", login);
        return new ResultInfo(CommonEnum.SUCCESS.getResultCode(),
                CommonEnum.SUCCESS.getResultMsg(),login);
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
            //TODO 判空
        }
        if(!code.equals(user.getCode())){
            //TODO 验证码不一致
        }
        int add = userService.add(user);
        if(add!=1){
            //TODO 添加失败
        }
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
