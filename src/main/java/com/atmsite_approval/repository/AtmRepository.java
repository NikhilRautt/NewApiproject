package com.atmsite_approval.repository;

import com.atmsite_approval.entity.Atmsite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtmRepository extends JpaRepository<Atmsite, Integer> {


    Optional<Atmsite> findByFrId(String frId);
}

