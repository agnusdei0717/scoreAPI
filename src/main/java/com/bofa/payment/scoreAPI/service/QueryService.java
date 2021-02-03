package com.bofa.payment.scoreAPI.service;

import com.bofa.payment.scoreAPI.pojo.AgentPoint;

import java.util.List;

public interface QueryService {

    List<?> getQueryData(String kind, String name, String year, String month, Integer status, Integer agent, String receiveDate, String endDate);
    AgentPoint getScore(Integer id, Integer year, Integer month);
}
