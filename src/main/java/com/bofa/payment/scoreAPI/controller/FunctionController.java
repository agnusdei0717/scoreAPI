package com.bofa.payment.scoreAPI.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunctionController {
    private Log log = LogFactory.getLog(FunctionController.class);

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/query")
    public String query(){
        return "query/query";
    }

    @RequestMapping("/report")
    public String report(){
        return "report/report";
    }

    @RequestMapping("/mainMenu")
    public String mainMenu(){
        return "mainMenu";
    }

    @RequestMapping("/newDevelopement")
    public String newDevelopement(){
        return "add/developement";
    }

    @RequestMapping("/newUpdateOrRebuild")
    public String newUpdateOrRebuild(){
        return "add/rebuild";
    }

    @RequestMapping("/newQuestion")
    public String newQuestion(){
        return "add/question";
    }
}
