package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.service.RebuildService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RebuildController {
    private Log log = LogFactory.getLog(RebuildController.class);

    @Autowired
    RebuildService rebuildService;

    @RequestMapping("/addRebuild")
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
        rebuildService.addRebuild(name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                                            ,remark,year,month,type);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add/rebuild");
        return mv;
    }

    @RequestMapping("/updateRebuild")
    public ModelAndView update(  @RequestParam("id") Integer Id
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
                                ,@RequestParam("type") Integer type){
        ModelAndView mv = new ModelAndView();
        mv.addObject("reData",rebuildService.updateRebuild(Id,name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                ,remark,year,month,type));
        mv.setViewName("edit/editRebuild");
        return mv;
    }
}
