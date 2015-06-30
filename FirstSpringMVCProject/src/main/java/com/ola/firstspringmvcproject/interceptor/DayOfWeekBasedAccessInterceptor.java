/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.interceptor;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Olaa
 */
public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{//najpierw to sie wywoluje potem kontroler
        //if this method returns true then application will further handle the request
        //if this method returns false then application will not further handle the request
        Calendar cal = Calendar.getInstance();
        
        int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
        
        if(dayOfWeek == 1){//1 means Sunday, 2 means Monday... 7 means Saturday - z twojego kalendarza Windowsowskiego(?)
            
            response.getWriter().write("This website is closed on Sunday");
            return false;
        }
        return true;
    }
    
    @Override//po kontrolerze, pozniej np. admissionForm
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        //this method would be called after Spring MVC executes the request handler method for the request
        System.out.println("HandlerInterceptorAdapter: Spring MVC called postHandle method for " + request.getRequestURI().toString());
    }
    
    @Override// po np. admissionForm
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception{
        //this method would be called after the response object is produced by the view for the request
        System.out.println("HandlerInterceptorAdapter: Spring MVC called afterCompletion method for " + request.getRequestURI().toString());
    }
}
