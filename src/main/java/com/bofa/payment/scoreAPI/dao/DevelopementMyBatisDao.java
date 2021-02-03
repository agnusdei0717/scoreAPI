package com.bofa.payment.scoreAPI.dao;

import com.bofa.payment.scoreAPI.pojo.Developement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DevelopementMyBatisDao {

      List<Developement> findByParameter(Map paraMap);

}
