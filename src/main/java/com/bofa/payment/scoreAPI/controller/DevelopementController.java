package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.service.DevelopementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DevelopementController {
    private Log log = LogFactory.getLog(DevelopementController.class);

    @Autowired
    DevelopementService developementService;

    @RequestMapping("/addDevelopement")
    public ModelAndView add( @RequestParam("name") String name
                            ,@RequestParam("receiveDate") String receiveDate
                            ,@RequestParam("status") Integer status
                            ,@RequestParam("agent") Integer agent
                            ,@RequestParam("situation") String situation
                            ,@RequestParam("endDate") String endDate
                            ,@RequestParam("uat_result") String uat_result
                            ,@RequestParam("prd_result") String prd_result
                            ,@RequestParam("remark") String remark
                            ,@RequestParam("year") String year
                            ,@RequestParam("month") String month
                            ,@RequestParam("type") Integer type
                                                                ){
        developementService.addDevelopement(name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                                            ,remark,year,month,type);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add/developement");
        return mv;
    }

    @RequestMapping("/updateDevelopement")
    public ModelAndView add( @RequestParam("id") Integer Id
            ,@RequestParam("name") String name
            ,@RequestParam("receiveDate") String receiveDate
            ,@RequestParam("status") Integer status
            ,@RequestParam("agent") Integer agent
            ,@RequestParam("situation") String situation
            ,@RequestParam("endDate") String endDate
            ,@RequestParam("uat_result") String uat_result
            ,@RequestParam("prd_result") String prd_result
            ,@RequestParam("remark") String remark
            ,@RequestParam("year") String year
            ,@RequestParam("month") String month
            ,@RequestParam("type") Integer type
    ){
        developementService.updateDevelopement(Id,name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                ,remark,year,month,type);
        ModelAndView mv = new ModelAndView();
        mv.addObject("deData",developementService.findById(Id).get());
        mv.setViewName("edit/editDevelopement");
        return mv;
    }
}
