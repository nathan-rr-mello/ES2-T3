package com.service.subreg.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.subreg.domain.repository.ClassRepository;
import com.service.subreg.domain.model.Class;

@Service
public class ClassService {
    private ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public void save(Class classroom){
        classRepository.save(classroom);
    }
}
