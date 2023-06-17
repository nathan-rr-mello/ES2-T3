package com.service.subreg.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENROLLMENT")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long studentId;
    public Long classroomId;
    public Long classroomValue;

    public Enrollment() {
    }

    public Enrollment(Long studentId, Long classroomId, Long classroomValue) {
        this.classroomValue = classroomValue;
        this.studentId = studentId;
        this.classroomId = classroomId;
    }

    public Long getStudentId() {
        return studentId;
    }   

    public Long getClassroomValue() {
        return classroomValue;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }  

    public void setClassroomValue(Long classroomValue) {
        this.classroomValue = classroomValue;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }
}
