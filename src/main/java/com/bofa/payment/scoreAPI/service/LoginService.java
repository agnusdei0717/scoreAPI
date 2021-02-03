package com.bofa.payment.scoreAPI.service;

import com.bofa.payment.scoreAPI.pojo.Agent;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    Agent findByIdAndPassword(String loginID, String password);
    void setAllData(HttpServletRequest req, Agent agent);
}
