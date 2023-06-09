package com.service.subreg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.subreg.domain.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
}
