package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.pojo.Developement;
import com.bofa.payment.scoreAPI.repository.DevelopementRepository;
import com.bofa.payment.scoreAPI.service.DevelopementService;
import com.bofa.payment.scoreAPI.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DevelopementServiceImpl implements DevelopementService {

    private Log log = LogFactory.getLog(DevelopementServiceImpl.class);

    @Autowired
    DevelopementRepository developementRepository;


    @Override
    public void addDevelopement(String name, String receiveDate, Integer status, Integer agent, String situation
                        , String endDate, String uatResult, String prdResult, String remark, String year, String month
                        , Integer type) {

        Developement de = new Developement(name, DateUtil.parseStringToDate(receiveDate), status, agent, situation
                , DateUtil.parseStringToDate(endDate), uatResult, prdResult, remark, year, month, type);
        developementRepository.save(de);
    }

    @Override
    public Developement updateDevelopement(Integer Id, String name, String receiveDate, Integer status, Integer agent
            , String situation, String endDate, String uatResult, String prdResult, String remark, String year
            , String month, Integer type) {
        Developement de = new Developement(Id, name, DateUtil.parseStringToDate(receiveDate), status, agent, situation
                , DateUtil.parseStringToDate(endDate), uatResult, prdResult, remark, year, month, type);
        return developementRepository.save(de);
    }

    @Override
    public Optional<Developement> findById(Integer id) { return developementRepository.findById(id);
    }

    @Override
    public Developement findByPayName(String name) {
        return developementRepository.findByName(name);
    }

    @Override
    public void delById(Integer Id) {
        developementRepository.delete(new Developement(Id));
    }
}
