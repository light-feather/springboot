package com.charis.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,
                                            Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        //设置返回值
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        //设置返回页面名称
        mav.setViewName("errorPage");
        return mav;
    }
}
