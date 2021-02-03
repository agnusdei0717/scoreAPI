package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.service.QueryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QueryController {
    private Log log = LogFactory.getLog(QueryController.class);

    @Autowired
    QueryService queryService;

    @RequestMapping("queryData")
    public ModelAndView queryData(@RequestParam("kind") String kind
                            , @RequestParam("name") String name
                            , @RequestParam("year") String year
                            , @RequestParam("month") String month
                            , @RequestParam("status") Integer status
                            , @RequestParam("agent") Integer agent
                            , @RequestParam("receiveDate") String receiveDate
                            , @RequestParam("endDate") String endDate
                            ){
        ModelAndView mv = new ModelAndView();
        mv.addObject("kind",kind);
        mv.addObject("display",true);
        mv.addObject("dataList",queryService.getQueryData(kind,name,year,month,status,agent,receiveDate,endDate));
        mv.setViewName("query/query");
            return mv;
    }

    @ResponseBody
    @RequestMapping("getScore")
    public String queryData(@RequestParam("id") Integer id
            , @RequestParam("year") Integer year
            , @RequestParam("month") Integer month ){
        return queryService.getScore(id, year, month).toString();
    }

}
