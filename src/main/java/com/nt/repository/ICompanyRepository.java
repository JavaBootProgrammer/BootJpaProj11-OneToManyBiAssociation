package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Company;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {

}
