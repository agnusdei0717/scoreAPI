package com.bofa.payment.scoreAPI.repository;

import com.bofa.payment.scoreAPI.pojo.Developement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevelopementRepository extends JpaRepository<Developement,Integer> {

    Optional<Developement> findById(Integer Id);
    Developement findByName(String name);
}
