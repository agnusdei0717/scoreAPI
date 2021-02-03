package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.dao.AgentMyBatisDao;
import com.bofa.payment.scoreAPI.pojo.Agent;
import com.bofa.payment.scoreAPI.repository.AgentRepository;
import com.bofa.payment.scoreAPI.service.AgentSerivce;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentSerivce {

    private Log log = LogFactory.getLog(AgentServiceImpl.class);

    @Autowired
    AgentRepository agentDao;

    @Autowired
    AgentMyBatisDao batisDao;

    @Override
    public List<Agent> getAgentRDList(Integer level) {
        return agentDao.findByLevel(level);
    }

    @Override
    public void addAgent(String cname, String ename, String password, Integer level) {
        Agent ag = new Agent(password, cname, ename, level);
        agentDao.save(ag);
    }

    @Override
    public List<Agent> findAgents(Agent agent) {
        return batisDao.findAgents(agent);
    }

    @Override
    public void deleteAgent(Integer id) {
        Agent agent=new Agent();
        agent.setId(id);

        agentDao.delete(agent);
    }

    @Override
    public Agent saveAgent(Agent agent) {
        return agentDao.save(agent);
    }

}