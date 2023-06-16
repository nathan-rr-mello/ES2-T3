package com.service.subsea.controller;

import com.service.subsea.domain.model.Class;
import com.service.subsea.domain.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassController {
    private final ClassService classroomService;

    @Autowired
    public ClassController(ClassService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public List<Class> getAllClasss() {
        return classroomService.findAll();
    }
}
