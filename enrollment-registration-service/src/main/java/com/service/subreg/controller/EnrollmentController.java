package com.service.subreg.controller;

import com.service.subreg.domain.model.Enrollment;
import com.service.subreg.domain.service.EnrollmentService;
import com.service.subreg.domain.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enroll")
public class EnrollmentController {
    @Autowired
    private final EnrollmentService enrollmentService;
    @Autowired
    private final EnrollmentRepository repository;
    @Autowired(required = false)
    private StudentProxy studentProxy;

    public EnrollmentController(EnrollmentService enrollmentService, EnrollmentRepository repository) {
        this.enrollmentService = enrollmentService;
        this.repository = repository;
    }

    @PostMapping
    public void saveEnroll(@RequestBody Enrollment enrollment){
        Enrollment enroll = studentProxy.getStudentById(enrollment.studentId);
        enroll.classroomValue = 2L;
        enroll.classroomId = 3L;
        enrollmentService.save(enroll);
    }
    // informar número de matrícula do estudante, código e turma da disciplina
    // @PostMapping("/enroll-student/{studentId}/in-classroom/{classroomValue}/{classroomId}")
    // public Enrollment enroller(@PathVariable Long studentId, @PathVariable Long classroomValue, @PathVariable Long classroomId) {
    //     Enrollment enrollment = repository.save(studentId, classroomValue, classroomId);
    //     enrollment.setStudentId(studentId);
    //     enrollment.setClassroomValue(classroomValue);
    //     enrollment.setClassroomId(classroomId);
    //     return enrollment;
    // }
}
