package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.dao.ScoreMybatisDao;
import com.bofa.payment.scoreAPI.pojo.Agent;
import com.bofa.payment.scoreAPI.repository.AgentRepository;
import com.bofa.payment.scoreAPI.repository.ScoreCodeRepository;
import com.bofa.payment.scoreAPI.service.LoginService;
import com.bofa.payment.scoreAPI.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private Log log = LogFactory.getLog(LoginServiceImpl.class);
    @Autowired
    AgentRepository agentDao;

    @Autowired
    ScoreCodeRepository scoreCodeDao;

    @Autowired
    ScoreMybatisDao scoreMyBatisDao;

    @Override
    public Agent findByIdAndPassword(String ename, String password) {
        return agentDao.findByEnameAndPassword(ename,password);
    }

    @Override
    public void setAllData(HttpServletRequest req, Agent agent) {
        List<Agent> agentList = agentDao.findByLevel(1);
        String currentYear = DateUtil.getDateFormateStr("year");
        String currentMonth = DateUtil.getDateFormateStr("month");

        req.getSession().setAttribute("userAgent",agent);
        req.getSession().setAttribute("agnetList",agentList);
        req.getSession().setAttribute("statusList",scoreCodeDao.findByCodeKindAndCodeName("all","status"));
        req.getSession().setAttribute("developementTypeList",scoreCodeDao.findByCodeKindAndCodeName("developement","type"));
        req.getSession().setAttribute("rebuildTypeList",scoreCodeDao.findByCodeKindAndCodeName("rebuild","type"));
        req.getSession().setAttribute("currentDate",DateUtil.formatDate());
        req.getSession().setAttribute("currentYear", Integer.parseInt(currentYear));
        req.getSession().setAttribute("currentMonth",Integer.parseInt(currentMonth));
//        for(Agent a:agentList) {
//            req.getSession().setAttribute("agentPoint"+a.getId(), scoreMyBatisDao.getPoint(Integer.parseInt(currentYear), Integer.parseInt(currentMonth), a.getId()).get(0));
//        }
    }
}
