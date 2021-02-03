package com.bofa.payment.scoreAPI.dao;

import com.bofa.payment.scoreAPI.pojo.Agent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AgentMyBatisDao {

      List<Agent> findAgents(Agent agent);

}
