package com.bofa.payment.scoreAPI.dao;

import com.bofa.payment.scoreAPI.pojo.AgentPoint;
import com.bofa.payment.scoreAPI.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreMybatisDao {

    List<Score> getScoreByYearAndMonthAndAgent(@Param("year") Integer year,@Param("month") Integer month,@Param("agent") Integer agent);
    List<AgentPoint> getPoint(@Param("year") Integer year, @Param("month") Integer month, @Param("agent") Integer agent);
    List<Score> getScoreByYearAndMonthForQA(@Param("year") Integer year,@Param("month") Integer month);
}
