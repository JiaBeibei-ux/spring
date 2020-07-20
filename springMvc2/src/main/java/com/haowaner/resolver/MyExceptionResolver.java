package com.haowaner.resolver;

import com.haowaner.exception.SysException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        SysException e;
        //获取到的异常就是ex
        if(ex instanceof SysException){
            e= (SysException) ex;
        }else{
            e = new SysException("系统异常！");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",e.getMsg());
        mv.setViewName("error");
        return mv;
    }
}
