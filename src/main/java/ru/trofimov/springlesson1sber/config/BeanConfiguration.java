package ru.trofimov.springlesson1sber.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.trofimov.springlesson1sber.data.Student;
import ru.trofimov.springlesson1sber.data.enums.Grade;
import ru.trofimov.springlesson1sber.data.enums.Subject;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("ru.trofimov.springlesson1sber.data")
public class BeanConfiguration {

    @Bean
    public Student student1() {
        Map<Subject, Grade> performance = new HashMap<>();

        performance.put(Subject.MATHEMATICS, Grade.F);
        performance.put(Subject.PHYSICS, Grade.D);
        performance.put(Subject.INFORMATICS, Grade.D);
        performance.put(Subject.RUSSIAN_LANGUAGE, Grade.F);

        return new Student("Emma", performance);
    }

    @Bean
    public Student student2() {
        Map<Subject, Grade> performance = new HashMap<>();

        performance.put(Subject.MATHEMATICS, Grade.B);
        performance.put(Subject.PHYSICS, Grade.D);
        performance.put(Subject.INFORMATICS, Grade.B);
        performance.put(Subject.RUSSIAN_LANGUAGE, Grade.B);

        return new Student("Michael", performance);
    }

    @Bean
    public Student student3() {
        Map<Subject, Grade> performance = new HashMap<>();

        performance.put(Subject.MATHEMATICS, Grade.F);
        performance.put(Subject.PHYSICS, Grade.F);
        performance.put(Subject.INFORMATICS, Grade.F);
        performance.put(Subject.RUSSIAN_LANGUAGE, Grade.F);

        return new Student("Jil", performance);
    }

    @Bean
    public static BeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
