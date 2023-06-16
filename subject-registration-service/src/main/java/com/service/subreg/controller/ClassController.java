package com.service.subreg.controller;

import com.service.subreg.domain.model.Class;
import com.service.subreg.domain.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classrooms")
public class ClassController {
    private final ClassService classroomService;

    @Autowired
    public ClassController(ClassService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping
    public void save(@RequestBody Class classroom){
        classroomService.save(classroom);
    }
}
