package ru.trofimov.springlesson1sber.data;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher")
public class Lecturer {

    private String name;
    private String subject;
    List<Student> students;

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
