package com.bofa.payment.scoreAPI.dao;

import com.bofa.payment.scoreAPI.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionMyBatisDao {

      List<Question> findByParameter(Map paraMap);

}
