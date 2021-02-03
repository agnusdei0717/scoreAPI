package com.bofa.payment.scoreAPI.repository;

import com.bofa.payment.scoreAPI.pojo.Rebuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RebuildRepository extends JpaRepository<Rebuild,Integer> {
    Optional<Rebuild> findById(Integer Id);
    Rebuild findByName(String name);
}
