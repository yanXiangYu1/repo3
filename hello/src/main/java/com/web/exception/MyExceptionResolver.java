package com.web.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        ModelAndView mv = new ModelAndView();
        System.out.println("出错啦!!!");
        String message = null;
        if (e instanceof MyException){
            message = "未知错误!!!请联系管理员!!!";
        }else {
            message = e.getMessage();

        }
        mv.addObject("errorl",message);
        //mv.setViewName("error");
        mv.setViewName("error");
        return mv;
    }
}
