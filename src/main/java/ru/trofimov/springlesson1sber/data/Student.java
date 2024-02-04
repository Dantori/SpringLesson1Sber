package ru.trofimov.springlesson1sber.data;

import ru.trofimov.springlesson1sber.data.enums.Grade;
import ru.trofimov.springlesson1sber.data.enums.Subject;

import java.util.ArrayList;
import java.util.List;
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

    private double calculateAverageGrade() {
        List<Integer> grades = new ArrayList<>();
        for (Grade grade : performance.values()) {
            grades.add(grade.getValue());
        }
        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        if (grades.isEmpty()) {
            return 0.0;
        } else {
            return (double) sum / grades.size();
        }
    }

    private void init() {
        if (calculateAverageGrade() >= 3) {
            setStatus(true);
        }
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", performance=" + performance +
                ", status=" + status +
                '}';
    }
}
