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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/delete")
public class DeleteController {

    private Log log = LogFactory.getLog(EditController.class);

    @Autowired
    DevelopementService developementService;

    @Autowired
    QuestionService questionService;

    @Autowired
    RebuildService rebuildService;

    @RequestMapping("developement")
    @ResponseBody
    public String deleteDevelopement(@RequestParam("id") Integer Id){
        try {
            developementService.delById(Id);
            return "{\"process_status\":\"成功\"}";
        }catch (Exception e){
            return "{\"process_status\":\"失敗\"}";
        }
    }

    @RequestMapping("question")
    @ResponseBody
    public String deleteQuestion(@RequestParam("id") Integer Id){
        try{
            questionService.delById(Id);
            return "{\"process_status\":\"成功\"}";
        }catch (Exception e){
            return "{\"process_status\":\"失敗\"}";
        }
    }

    @RequestMapping("rebuild")
    @ResponseBody
    public String deleteRebuild(@RequestParam("id") Integer Id){
        try{
            rebuildService.delById(Id);
            return "{\"process_status\":\"成功\"}";
        }catch (Exception e){
            return "{\"process_status\":\"失敗\"}";
        }
    }
}
