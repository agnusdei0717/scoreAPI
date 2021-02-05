package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.Component.ResultJSONObj;
import com.bofa.payment.scoreAPI.pojo.Developement;
import com.bofa.payment.scoreAPI.service.DevelopementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class DevelopementController {
    private Log log = LogFactory.getLog(DevelopementController.class);

    @Autowired
    DevelopementService developementService;

    @Autowired
    ResultJSONObj resultJson;

    @RequestMapping("/add/Developement")
    public String add( @RequestParam("name") String name
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
        resultJson.setSuccess(true).setMsg("新增成功").addData("developement",developementService.addDevelopement(name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                ,remark,year,month,type));

        return resultJson.toString();
    }

    @RequestMapping("/update/Developement")
    public String update( @RequestParam("id") Integer Id
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
        resultJson.setSuccess(true).setMsg("更新成功").addData("developement",developementService.updateDevelopement(Id,name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                ,remark,year,month,type));
        return resultJson.toString();
    }

    @RequestMapping("/delete/developement/{id}")
    public String delete(@PathVariable Integer id){
        developementService.delById(id);
        resultJson.setSuccess(true).setMsg("刪除成功");
        return resultJson.toString();
    }

    @RequestMapping("/query/developement/{id}")
    public String query(@PathVariable Integer id){
        developementService.findById(id);
        resultJson.setSuccess(true).setMsg("查詢成功").addData("developement",developementService.findById(id));
        return resultJson.toString();
    }

//    @RequestMapping("/add/Developement")
//    public String add( @RequestBody Developement developement){
//        resultJson.setSuccess(true).setMsg("新增成功").addData("developement",developementService.addDevelopement(developement));
//        return resultJson.toString();
//    }

//    @RequestMapping("/update/Developement")
//    public String update( @RequestBody Developement developement){
//        resultJson.setSuccess(true).setMsg("更新成功").addData("developement",developementService.updateDevelopement(developement));
//        return resultJson.toString();
//    }

}
