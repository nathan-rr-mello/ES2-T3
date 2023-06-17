package com.service.subsea.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.subsea.domain.model.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>{
}
