package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.dao.DevelopementMyBatisDao;
import com.bofa.payment.scoreAPI.dao.QuestionMyBatisDao;
import com.bofa.payment.scoreAPI.dao.RebuildMyBatisDao;
import com.bofa.payment.scoreAPI.dao.ScoreMybatisDao;
import com.bofa.payment.scoreAPI.pojo.AgentPoint;
import com.bofa.payment.scoreAPI.service.QueryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {
    private Log log = LogFactory.getLog(QueryServiceImpl.class);

    @Autowired
    DevelopementMyBatisDao deDao;

    @Autowired
    RebuildMyBatisDao reDao;

    @Autowired
    QuestionMyBatisDao quDao;

    @Autowired
    ScoreMybatisDao scoreMyBatisDao;

    @Override
    public List<?> getQueryData(String kind, String name, String year, String month, Integer status, Integer agent, String receiveDate, String endDate) {
        Map paraMap = new HashMap();

        if(name != null && !name.equals(""))
            paraMap.put("name", "%" + name + "%");
        paraMap.put("year",year);
        paraMap.put("month",month);
        paraMap.put("status",status);
        paraMap.put("agent",agent);
        paraMap.put("receiveDate",receiveDate);
        paraMap.put("endDate",endDate);

        List<?> resultList = null;

        if("developement".equals(kind)){
            resultList = deDao.findByParameter(paraMap);
        }else if("rebuild".equals(kind)){
            resultList = reDao.findByParameter(paraMap);
        }else if("question".equals(kind)){
            resultList = quDao.findByParameter(paraMap);
        }

        return resultList;
    }

    @Override
    public AgentPoint getScore(Integer id, Integer year, Integer month) {
        return scoreMyBatisDao.getPoint(year, month, id).get(0);
    }
}
