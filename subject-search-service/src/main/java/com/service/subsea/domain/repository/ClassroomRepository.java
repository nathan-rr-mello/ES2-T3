package com.service.subsea.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.subsea.domain.model.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
}
