package com.bofa.payment.scoreAPI.service;

import com.bofa.payment.scoreAPI.pojo.Question;

import java.util.Optional;

public interface QuestionService {

    Question addQuestion( String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
            , String remark, String year, String month);
    Question addQuestion( Question question);
    Question updateQuestion( Integer Id, String name, String receiveDate, Integer status, Integer agent, String situation, String endDate
            , String remark, String year, String month);
    Question updateQuestion( Question question);
    Optional<Question> findById(Integer id);
    Question findByPayName(String payName);
    void delById(Integer Id);
}
