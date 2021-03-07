package com.halfsummer.baseframework.interceptor;

import com.halfsummer.baseframework.enums.CommonEnum;
import com.halfsummer.baseframework.result.ResultDataUtil;
import com.halfsummer.baseframework.util.ResopseUtil;
import com.halfsummer.baseframework.vo.LoginUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author BestClever
 * @title: LoginInterceptor
 * @projectName kaoqin
 * @description: TODO
 * @date 2020-05-28 11:07
 */

public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 在控制器执行之前完成业务逻辑操作
     * 方法的返回值决定逻辑是否继续执行， true，表示继续执行， false, 表示不再继续执行。
     */
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {

//        // 判断当前用户是否已经登陆
//        HttpSession session = request.getSession();
//        LoginUserVo loginUser = (LoginUserVo) session.getAttribute("loginUser");
//        request.setCharacterEncoding("utf-8"); // 设置编码为utf初-8
//        response.setContentType("text/html;charset=utf-8");
//        if (loginUser == null) {
//            // Ajax请求会话过期处理
//            String requestType = request.getHeader("X-Requested-With");
//            if (StringUtils.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")) {
//                response.setHeader("SessionStatus", "sessionTimeOut");
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//没有权限
//                ResopseUtil.responseOutWithJson(response, ResultDataUtil.createFail(CommonEnum.SIGNATURE_NOT_MATCH));
//                return false;
//            }
//            String path = session.getServletContext().getContextPath();
//            response.sendRedirect(path + "/login");
//            return false;
//        } else {
//            return true;
//        }
//    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    /**
     * 在控制器执行完毕之后执行的逻辑操作
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 在完成视图渲染之后，执行此方法。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }




}