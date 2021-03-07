package com.halfsummer.management.user.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
@RequestMapping("/user/auth")
public class AuthCodeController {
    /**
     * 验证码生成类
     *
     * @param request
     * @param response
     */
    @RequestMapping("/code")
    public void validatePic(HttpServletRequest request, HttpServletResponse response) {
        RandomGenerator randomGenerator = new RandomGenerator("0123456789abcdefghiklmnopqrstxyz", 4);
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100);
        captcha.setGenerator(randomGenerator);
        //得到code
        String code = captcha.getCode();
        System.out.println(code);
        //放到session
        request.getSession().setAttribute("code", code);
        //输出流
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            //读写输出流
            captcha.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
