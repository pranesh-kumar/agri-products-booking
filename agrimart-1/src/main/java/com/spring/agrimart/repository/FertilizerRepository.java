package com.spring.agrimart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.agrimart.model.FertilizerModel;
@Repository
public interface FertilizerRepository extends JpaRepository<FertilizerModel, Integer> {

}