package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {
    private Log log = LogFactory.getLog(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @RequestMapping("/addQuestion")
    public ModelAndView add( @RequestParam("name") String name
                            ,@RequestParam("receiveDate") String receiveDate
                            ,@RequestParam("status") Integer status
                            ,@RequestParam("agent") Integer agent
                            ,@RequestParam("situation") String situation
                            ,@RequestParam("endDate") String endDate
                            ,@RequestParam("remark") String remark
                            ,@RequestParam("year") String year
                            ,@RequestParam("month") String month){
        questionService.addQuestion(name,receiveDate,status,agent,situation,endDate,remark,year,month);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add/question");
        return mv;
    }

    @RequestMapping("/updateQuestion")
    public ModelAndView update(  @RequestParam("id") Integer Id
                                ,@RequestParam("name") String name
                                ,@RequestParam("receiveDate") String receiveDate
                                ,@RequestParam("status") Integer status
                                ,@RequestParam("agent") Integer agent
                                ,@RequestParam("situation") String situation
                                ,@RequestParam("endDate") String endDate
                                ,@RequestParam("remark") String remark
                                ,@RequestParam("year") String year
                                ,@RequestParam("month") String month){
        ModelAndView mv = new ModelAndView();
        mv.addObject("quData",questionService.updateQuestion(Id,name,receiveDate,status,agent,situation,
                                                                            endDate,remark,year,month));
        mv.setViewName("edit/editQuestion");
        return mv;
    }


}
