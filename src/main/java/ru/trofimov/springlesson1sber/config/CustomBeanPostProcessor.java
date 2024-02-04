package ru.trofimov.springlesson1sber.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.trofimov.springlesson1sber.data.Student;
import ru.trofimov.springlesson1sber.data.enums.Grade;
import ru.trofimov.springlesson1sber.data.enums.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student && "Jil".equals(((Student) bean).getName())) {
            Map<Subject, Grade> performance = ((Student) bean).getPerformance();
            if (!((Student) bean).isStatus()) {
                for (Map.Entry<Subject, Grade> entry : performance.entrySet()) {
                    if (entry.getValue().getValue() < 3) {
                        performance.put(entry.getKey(), Grade.A);
                    }
                }
                System.out.println("Jil's grades have been increased!");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student student) {
            if (calculateAverageGrade(student.getPerformance()) >= 3.0) {
                student.setStatus(true);
            }
        }
        return bean;
    }

    private double calculateAverageGrade(Map<Subject, Grade> performance) {
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
}
