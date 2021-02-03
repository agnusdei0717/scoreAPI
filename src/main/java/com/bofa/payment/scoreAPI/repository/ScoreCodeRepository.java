package com.bofa.payment.scoreAPI.repository;

import com.bofa.payment.scoreAPI.pojo.ScoreCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreCodeRepository extends JpaRepository<ScoreCode,Integer> {
    List<ScoreCode> findAll();
    List<ScoreCode> findByCodeKindAndCodeName(String code_kind, String code_name);
}
