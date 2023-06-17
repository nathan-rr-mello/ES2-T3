package com.service.subreg.controller;

import com.service.subreg.domain.model.Enrollment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

@FeignClient(name = "student")
public interface StudentProxy {
    @GetMapping("/search/{id}")
    public Enrollment getStudentById(@PathVariable Long id);
}