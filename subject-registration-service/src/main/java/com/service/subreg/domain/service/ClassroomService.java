package com.service.subreg.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.subreg.domain.repository.ClassroomRepository;
import com.service.subreg.domain.model.Classroom;

@Service
public class ClassroomService {
    private ClassroomRepository classRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Classroom> findAll() {
        return classRepository.findAll();
    }
}
