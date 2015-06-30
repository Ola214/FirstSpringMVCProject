/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Olaa
 */
/*1.
public class HelloController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ModelAndView modelAndView = new ModelAndView("HelloPage");
        modelAndView.addObject("welcomeMessage","Hi user, welcome to the first Spring MVC Application");
        return modelAndView;
    }
    
}
*/

@Controller
@RequestMapping("/greet")
public class HelloController{
    
    @RequestMapping("/welcome/{userName}/{greetText}")
    public ModelAndView helloWorld(/*@PathVariable("userName") String name, @PathVariable("greetText") String greetText*/ @PathVariable Map<String,String> pathVars){ //@PathVariable pobiera ze sciezki parametr np. greet/welcome/ola to bedzie name="ola"
        String name = pathVars.get("userName");
        String greetText = pathVars.get("greetText");
        
        ModelAndView modelAndView = new ModelAndView("HelloPage");
        modelAndView.addObject("welcomeMessage",  greetText+" "+name);
        return modelAndView;
    }
    
    @RequestMapping("/hi")
    public ModelAndView hiWorld(){
        ModelAndView modelAndView = new ModelAndView("HelloPage");
        modelAndView.addObject("welcomeMessage", "hi world!");
        return modelAndView;
    }
}
