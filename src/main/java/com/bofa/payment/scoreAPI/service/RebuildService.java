package com.bofa.payment.scoreAPI.service;


import com.bofa.payment.scoreAPI.pojo.Rebuild;

import java.util.Optional;

public interface RebuildService {

    Rebuild addRebuild( String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
            , String uatResult, String prdResult, String remark, String year, String month, Integer type);
    Rebuild addRebuild( Rebuild rebuild);
    Rebuild updateRebuild( Integer Id, String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
            , String uatResult, String prdResult, String remark, String year, String month, Integer type);
    Rebuild updateRebuild( Rebuild rebuild);
    Optional<Rebuild> findById(Integer id);
    Rebuild findByPayName(String payName);
    void delById(Integer Id);
}
