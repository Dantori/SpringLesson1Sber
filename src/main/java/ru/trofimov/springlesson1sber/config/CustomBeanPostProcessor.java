package ru.trofimov.springlesson1sber.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.trofimov.springlesson1sber.data.Student;
import ru.trofimov.springlesson1sber.data.enums.Grade;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student student && "Jil".equals(student.getName()) && !student.isStatus()) {
            student.getPerformance().entrySet().stream()
                    .filter(entry -> entry.getValue().getValue() < 3)
                    .forEach(entry -> student.getPerformance().put(entry.getKey(), Grade.A));
            System.out.println("Jil's grades have been increased!");
        }
        return bean;
    }
}
