package com.service.subreg.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLASSROOM")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    @ManyToOne
    private Subject subject;

    public Classroom() {
    }

    public Classroom(int number, Subject subject) {
        this.number = number;
        this.subject = subject;
    }

    public Long getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int class_number) {
        this.number = class_number;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String toString() {
        return "Class [id=" + this.id + ", number=" + this.number + ", subject=" + this.subject + "]";
    }
}