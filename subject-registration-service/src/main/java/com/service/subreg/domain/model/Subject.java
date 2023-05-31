package com.service.subreg.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "subject")
    private List<Classroom> classes;
    private String cod;
    private String name;
    private String schedule;

    public Subject() {
    }

    public Subject(String cod, String name, String schedule) {
        this.cod = cod;
        this.name = name;
        this.schedule = schedule;
    }

    public Long getId() {
        return this.id;
    }

    public String getCod() {
        return this.cod;
    }

    public String getName() {
        return this.name;
    }   

    public String getSchedule() {
        return this.schedule;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setName(String name) {
        this.name = name;
    }  

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }  

    public List<Classroom> getClasses() {
        return this.classes;
    }

    public void setClasses(List<Classroom> classes) {
        this.classes = classes;
    }

    public String toString() {
        return "Subject [id=" + this.id + ", cod=" + this.cod + ", name=" + this.name + ", schedule=" + this.schedule + "]";
    }
}
