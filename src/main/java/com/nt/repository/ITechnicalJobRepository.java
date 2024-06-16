package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.TechnicalJob;

public interface ITechnicalJobRepository extends JpaRepository<TechnicalJob, Integer> {

}
