package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.pojo.ScoreCode;
import com.bofa.payment.scoreAPI.repository.ScoreCodeRepository;
import com.bofa.payment.scoreAPI.service.ScoreCodeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCodeServiceImpl implements ScoreCodeService {

    private Log log = LogFactory.getLog(ScoreCodeServiceImpl.class);

    @Autowired
    ScoreCodeRepository scoreCodeRepository;


    @Override
    public List<ScoreCode> findAll() {
        return scoreCodeRepository.findAll();
    }
}
