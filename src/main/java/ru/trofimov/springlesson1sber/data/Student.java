package ru.trofimov.springlesson1sber.data;

import ru.trofimov.springlesson1sber.data.enums.Grade;
import ru.trofimov.springlesson1sber.data.enums.Subject;

import java.util.Map;

public class Student {

    private final String name;
    private final Map<Subject, Grade> performance;
    private boolean status = false;

    public Student(String name, Map<Subject, Grade> performance) {
        this.name = name;
        this.performance = performance;
    }

    public String getName() {
        return name;
    }

    public Map<Subject, Grade> getPerformance() {
        return performance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", performance=" + performance +
                ", status=" + status +
                '}';
    }
}
