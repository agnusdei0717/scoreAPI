package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.Component.ResultJSONObj;
import com.bofa.payment.scoreAPI.pojo.Question;
import com.bofa.payment.scoreAPI.service.QuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class QuestionController {
    private Log log = LogFactory.getLog(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @Autowired
    ResultJSONObj resultJson;

    @RequestMapping("/add/Question")
    public String add( @RequestParam("name") String name
                            ,@RequestParam("receiveDate") String receiveDate
                            ,@RequestParam("status") Integer status
                            ,@RequestParam("agent") Integer agent
                            ,@RequestParam("situation") String situation
                            ,@RequestParam("endDate") String endDate
                            ,@RequestParam("remark") String remark
                            ,@RequestParam("year") String year
                            ,@RequestParam("month") String month){
        resultJson.setSuccess(true).setMsg("新增成功").addData("question",questionService.addQuestion(name,receiveDate,status,agent,situation,endDate,remark,year,month));
        return resultJson.toString();
    }

    @RequestMapping("/updat/eQuestion")
    public String update(  @RequestParam("id") Integer Id
                                ,@RequestParam("name") String name
                                ,@RequestParam("receiveDate") String receiveDate
                                ,@RequestParam("status") Integer status
                                ,@RequestParam("agent") Integer agent
                                ,@RequestParam("situation") String situation
                                ,@RequestParam("endDate") String endDate
                                ,@RequestParam("remark") String remark
                                ,@RequestParam("year") String year
                                ,@RequestParam("month") String month){
        resultJson.setSuccess(true).setMsg("更新成功").addData("question",questionService.updateQuestion(Id,name,receiveDate,status,agent,situation,
                endDate,remark,year,month));
        return resultJson.toString();
    }

    @RequestMapping("/delete/question/{id}")
    public String delete(@PathVariable Integer id){
        questionService.delById(id);
        resultJson.setSuccess(true).setMsg("刪除成功");
        return resultJson.toString();
    }

    @RequestMapping("/query/question/{id}")
    public String query(@PathVariable Integer id){
        resultJson.setSuccess(true).setMsg("查詢成功").addData("question",questionService.findById(id));
        return resultJson.toString();
    }

//    @RequestMapping("/add/Question")
//    public String add(@RequestBody Question question){
//        resultJson.setSuccess(true).setMsg("新增成功").addData("question",questionService.addQuestion(question));
//        return resultJson.toString();
//    }
//
//    @RequestMapping("/update/Question")
//    public String update(@RequestBody Question question){
//        resultJson.setSuccess(true).setMsg("更新成功").addData("question",questionService.updateQuestion(question));
//        return resultJson.toString();
//    }
}
