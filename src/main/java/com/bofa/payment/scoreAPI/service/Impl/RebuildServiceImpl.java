package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.pojo.Rebuild;
import com.bofa.payment.scoreAPI.repository.RebuildRepository;
import com.bofa.payment.scoreAPI.service.RebuildService;
import com.bofa.payment.scoreAPI.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RebuildServiceImpl implements RebuildService {

    private Log log = LogFactory.getLog(RebuildServiceImpl.class);

    @Autowired
    RebuildRepository rebuildRepository;

    @Override
    public Rebuild addRebuild(String name, String receiveDate, Integer status, Integer agent, String situation
            , String endDate, String uatResult, String prdResult, String remark, String year, String month
            , Integer type) {
        Rebuild re = new Rebuild(name, DateUtil.parseStringToDate(receiveDate), status, agent, situation
                , DateUtil.parseStringToDate(endDate), uatResult, prdResult, remark, year, month, type);
        return rebuildRepository.save(re);
    }

    @Override
    public Rebuild addRebuild(Rebuild rebuild) {
        return rebuildRepository.save(rebuild);
    }

    @Override
    public Rebuild updateRebuild(Integer Id, String name, String receiveDate, Integer status, Integer agent, String situation, String endDate, String uatResult, String prdResult, String remark, String year, String month, Integer type) {
        Rebuild re = new Rebuild(Id, name, DateUtil.parseStringToDate(receiveDate), status, agent, situation
                , DateUtil.parseStringToDate(endDate), uatResult, prdResult, remark, year, month, type);
        rebuildRepository.save(re);
        return rebuildRepository.save(re);
    }

    @Override
    public Rebuild updateRebuild(Rebuild rebuild) {
        return rebuildRepository.save(rebuild);
    }

    @Override
    public Optional<Rebuild> findById(Integer id) {
        return rebuildRepository.findById(id);
    }

    @Override
    public Rebuild findByPayName(String payName) {
        return rebuildRepository.findByName(payName);
    }

    @Override
    public void delById(Integer Id) {
        rebuildRepository.delete(new Rebuild(Id));
    }
}
