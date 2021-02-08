package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.Component.ResultJSONObj;
import com.bofa.payment.scoreAPI.pojo.Rebuild;
import com.bofa.payment.scoreAPI.service.RebuildService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class RebuildController {
    private Log log = LogFactory.getLog(RebuildController.class);

    @Autowired
    RebuildService rebuildService;

    @Autowired
    ResultJSONObj resultJson;

    @RequestMapping("/add/Rebuild")
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
        resultJson.setSuccess(true).setMsg("新增成功").addData("rebuild",rebuildService.addRebuild(name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                ,remark,year,month,type));
        return resultJson.toString();
    }

    @RequestMapping("/update/Rebuild")
    public String update(  @RequestParam("id") Integer Id
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
        resultJson.setSuccess(true).setMsg("更新成功").addData("rebuild",rebuildService.updateRebuild(Id,name,receiveDate,status,agent,situation,endDate,uat_result,prd_result
                ,remark,year,month,type));
        return resultJson.toString();
    }

    @RequestMapping("/delete/Rebuild/{id}")
    public String delete(@PathVariable Integer id){
        rebuildService.delById(id);
        resultJson.setSuccess(true).setMsg("刪除成功");
        return resultJson.toString();
    }

    @RequestMapping("/query/Rebuild")
    public String query(@PathVariable Integer id){
        resultJson.setSuccess(true).setMsg("查詢成功").addData("rebuild",rebuildService.findById(id));
        return resultJson.toString();
    }

//    @RequestMapping("/add/Rebuild")
//    public String add(@RequestBody Rebuild rebuild){
//        resultJson.setSuccess(true).setMsg("新增成功").addData("rebuild",rebuildService.addRebuild(rebuild));
//        return resultJson.toString();
//    }
//
//    @RequestMapping("/update/Rebuild")
//    public String update( @RequestBody Rebuild rebuild){
//        resultJson.setSuccess(true).setMsg("更新成功").addData("rebuild",rebuildService.updateRebuild(rebuild));
//        return resultJson.toString();
//    }
}
