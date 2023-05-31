package com.service.subreg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.subreg.domain.model.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
}
