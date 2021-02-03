package com.bofa.payment.scoreAPI.service;

import com.bofa.payment.scoreAPI.pojo.Agent;

import java.util.List;

public interface  AgentSerivce {

    List<Agent> getAgentRDList(Integer level);
    void addAgent(String cname, String ename, String password, Integer level);

    List<Agent> findAgents(Agent agent);

    void deleteAgent(Integer id);

    Agent saveAgent(Agent agent);

}

