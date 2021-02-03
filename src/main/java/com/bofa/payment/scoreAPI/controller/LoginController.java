package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.pojo.Agent;
import com.bofa.payment.scoreAPI.service.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("id") String loginID,
                              @RequestParam("password") String password, HttpServletRequest req){
        String viewName = "mainMenu";
        ModelAndView mv = new ModelAndView();
        Agent agent = loginService.findByIdAndPassword(loginID,password);
        if(null == agent){
            viewName = "error";
            mv.addObject("errorMsg","你沒有註冊過阿!");
        }
//        log.info("output:"+agent.toString());
        loginService.setAllData(req, agent);
        mv.setViewName(viewName);
        return mv;
    }
}
