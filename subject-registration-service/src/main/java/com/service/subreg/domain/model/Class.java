package com.service.subreg.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    @ManyToOne
    private Subject subject;

    public Class() {
    }

    public Class(int class_number, Subject subject) {
        this.number = class_number;
        this.subject = subject;
    }

    public Long getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public Subject getsubject() {
        return this.subject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int class_number) {
        this.number = class_number;
    }

    public void setsubject(Subject subject) {
        this.subject = subject;
    }

    public String toString() {
        return "Class [id=" + this.id + ", number=" + this.number + ", subject=" + this.subject + "]";
    }
}