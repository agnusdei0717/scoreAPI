package com.bofa.payment.scoreAPI.controller;

import com.bofa.payment.scoreAPI.service.ReportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

    private Log log = LogFactory.getLog(ReportController.class);

    @Autowired
    ReportService reportService;

    @RequestMapping("/getReport")
    public void getReport(@RequestParam("year") Integer year
                        , @RequestParam("month") Integer month
                        , HttpServletResponse res){
        reportService.getMonthScoreReport(year,month,res);
    }
}
