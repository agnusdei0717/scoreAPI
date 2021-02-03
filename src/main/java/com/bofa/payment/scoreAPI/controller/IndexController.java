package com.bofa.payment.scoreAPI.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    private Log log = LogFactory.getLog(IndexController.class);

    @RequestMapping("/")
    public void index(HttpServletRequest req, HttpServletResponse res){
        try {
            res.sendRedirect(req.getContextPath() + "/login.html");
        }catch(Exception e){
            log.info(e.toString());
        }
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest req, HttpServletResponse res){
        try {
            res.sendRedirect(req.getContextPath() + "/register.html");
        }catch(Exception e){
            log.info(e.toString());
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse res){
        try {
            req.getSession().removeAttribute("userAgent");
            res.sendRedirect(req.getContextPath() + "/login.html");
        }catch(Exception e){
            log.info(e.toString());
        }
    }
}
