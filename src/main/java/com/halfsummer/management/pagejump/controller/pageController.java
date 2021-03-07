package com.halfsummer.management.pagejump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * xxq
 * 页面跳转以及个人封装的方法
 */
@Controller
@RequestMapping
public class pageController {

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping("/adminLogin")
    public  String  adminLogin(){
        return  "indexAdmin";
    }
    /**
     * 管理员首页
     */
    /**
     * 管理员首页  mainAdmin.html
     */
    @RequestMapping("/mainAdmin")
    public  String  mainAdmin(){
        return  "mainAdmin";
    }

    /**
     * 获取ip地址
     */
    @ResponseBody
    @RequestMapping("/getIp")
    public  String getIp(){
        try {
            InetAddress ip4 = Inet4Address.getLocalHost();
            return  ip4.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
