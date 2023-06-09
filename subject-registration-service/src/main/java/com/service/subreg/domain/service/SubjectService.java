package com.service.subreg.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.subreg.domain.repository.SubjectRepository;
import com.service.subreg.domain.model.Subject;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void save(Subject subject){
        subjectRepository.save(subject);
    }
}
