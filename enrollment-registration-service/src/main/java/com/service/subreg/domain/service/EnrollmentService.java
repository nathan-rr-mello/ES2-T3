package com.service.subreg.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.subreg.domain.repository.EnrollmentRepository;
import com.service.subreg.domain.model.Enrollment;
import java.util.List;

@Service
public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public void save(Enrollment enrollment){
        enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> findBystudentId(Long studentId){
        return enrollmentRepository.findBystudentId(studentId);
    }
}
