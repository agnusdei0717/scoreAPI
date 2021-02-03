package com.bofa.payment.scoreAPI.service;

import javax.servlet.http.HttpServletResponse;

public interface ReportService {

    void getMonthScoreReport(Integer year, Integer month, HttpServletResponse res);
}
