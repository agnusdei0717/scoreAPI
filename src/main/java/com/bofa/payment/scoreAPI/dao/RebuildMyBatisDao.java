package com.bofa.payment.scoreAPI.dao;

import com.bofa.payment.scoreAPI.pojo.Rebuild;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RebuildMyBatisDao {

      List<Rebuild> findByParameter(Map paraMap);
}
