package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.service.DevelopementService;
import com.bofa.payment.scoreAPI.service.QuestionService;
import com.bofa.payment.scoreAPI.service.RebuildService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edit")
public class EditController {
    private Log log = LogFactory.getLog(EditController.class);

    @Autowired
    DevelopementService developementService;

    @Autowired
    QuestionService questionService;

    @Autowired
    RebuildService rebuildService;

    @RequestMapping("developement")
    public ModelAndView editDevelopement(@RequestParam("id") Integer Id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("deData",developementService.findById(Id).get());
        mv.setViewName("edit/editDevelopement");
        return mv;
    }

    @RequestMapping("question")
    public ModelAndView editQuestion(@RequestParam("id") Integer Id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("quData",questionService.findById(Id).get());
        mv.setViewName("edit/editQuestion");
        return mv;
    }

    @RequestMapping("rebuild")
    public ModelAndView editRebuild(@RequestParam("id") Integer Id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("reData",rebuildService.findById(Id).get());
        mv.setViewName("edit/editRebuild");
        return mv;
    }

}
