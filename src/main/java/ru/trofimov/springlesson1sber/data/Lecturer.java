package ru.trofimov.springlesson1sber.data;

import org.springframework.stereotype.Component;

@Component("Teacher")
public class Lecturer {

    private String name;
    private String subject;

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
