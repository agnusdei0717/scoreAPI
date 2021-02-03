package com.bofa.payment.scoreAPI.repository;

import com.bofa.payment.scoreAPI.pojo.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    Optional<Question> findById(Integer Id);
    Question findByName(String name);
}
