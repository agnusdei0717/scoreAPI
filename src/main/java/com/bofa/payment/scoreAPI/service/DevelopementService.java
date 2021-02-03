package com.bofa.payment.scoreAPI.service;

import com.bofa.payment.scoreAPI.pojo.Developement;

import java.util.Optional;

public interface DevelopementService {

    void addDevelopement( String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
                        , String uatResult, String prdResult, String remark, String year, String month, Integer type);
    Developement updateDevelopement(Integer Id, String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
            , String uatResult, String prdResult, String remark, String year, String month, Integer type);
    Optional<Developement> findById(Integer d);
    Developement findByPayName(String payName);
    void delById(Integer Id);
}
