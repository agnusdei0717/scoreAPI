package com.bofa.payment.scoreAPI.service;

import com.bofa.payment.scoreAPI.pojo.Developement;

import java.util.Optional;

public interface DevelopementService {

    Developement addDevelopement(String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
                        , String uatResult, String prdResult, String remark, String year, String month, Integer type);
    Developement addDevelopement(Developement developement);
    Developement updateDevelopement(Integer Id, String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
            , String uatResult, String prdResult, String remark, String year, String month, Integer type);
    Developement updateDevelopement(Developement developement);
    Optional<Developement> findById(Integer d);
    Developement findByPayName(String payName);
    void delById(Integer Id);
}
