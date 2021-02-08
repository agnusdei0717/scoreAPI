package com.bofa.payment.scoreAPI.service.Impl;

import com.bofa.payment.scoreAPI.pojo.Question;
import com.bofa.payment.scoreAPI.repository.QuestionRepository;
import com.bofa.payment.scoreAPI.service.QuestionService;
import com.bofa.payment.scoreAPI.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private Log log = LogFactory.getLog(QuestionServiceImpl.class);

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question addQuestion(String name, String receiveDate, Integer status, Integer agent, String situation
            , String endDate, String remark, String year, String month) {
        Question qu = new Question(name, DateUtil.parseStringToDate(receiveDate), status, agent, situation
                , DateUtil.parseStringToDate(endDate), remark, year, month);
        return questionRepository.save(qu);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Integer Id, String name, String receiveDate, Integer status, Integer agent, String situation, String endDate, String remark, String year, String month) {
        Question qu = new Question(Id, name, DateUtil.parseStringToDate(receiveDate), status, agent, situation
                , DateUtil.parseStringToDate(endDate), remark, year, month);
        return questionRepository.save(qu);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question findByPayName(String payName) {
        return questionRepository.findByName(payName);
    }

    @Override
    public void delById(Integer Id) {
        questionRepository.delete(new Question(Id));
    }
}
