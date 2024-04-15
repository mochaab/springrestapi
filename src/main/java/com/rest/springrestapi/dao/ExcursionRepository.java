package com.rest.springrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.springrestapi.entity.Excursion;

public interface ExcursionRepository extends JpaRepository<Excursion, Integer> {
    
}
