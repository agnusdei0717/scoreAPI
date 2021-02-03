package com.bofa.payment.scoreAPI.repository;

import com.bofa.payment.scoreAPI.pojo.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AgentRepository  extends JpaRepository<Agent,Integer> {

    @Transactional
    Agent findByEnameAndPassword(String LoginID, String Password);

    @Transactional
    List<Agent> findByLevel(Integer level);

    List<Agent> findByCname(String cname);
}
