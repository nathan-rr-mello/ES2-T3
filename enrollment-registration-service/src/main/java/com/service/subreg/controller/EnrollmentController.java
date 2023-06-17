package com.service.subreg.controller;

import com.service.subreg.domain.model.Enrollment;
import com.service.subreg.domain.service.EnrollmentService;
import com.service.subreg.domain.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

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
        Long studentId = enrollment.getStudentId();
        ResponseEntity<Enrollment> responseEntity = new RestTemplate().getForEntity("http://localhost:8081/search/{studentId}", Enrollment.class, studentId);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            enrollmentService.save(enrollment);
        }

    }
    // Consultar as disciplinas/turmas em que um estudante está matriculado
    @GetMapping("/{studentId}")
    public List<Enrollment> findBystudentId(@Valid @PathVariable Long studentId){
        List<Enrollment> enroll = enrollmentService.findBystudentId(studentId);
        System.out.println(enroll);
        return enroll;
    }

}
