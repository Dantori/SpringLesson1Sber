package ru.trofimov.springlesson1sber;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.trofimov.springlesson1sber.config.JavaContext;
import ru.trofimov.springlesson1sber.data.Student;

public class StartApp {

    public static void main(String[] args) {
        ApplicationContext contextXml = new ClassPathXmlApplicationContext("xmlContext.xml");
        ApplicationContext contextJava = new AnnotationConfigApplicationContext(JavaContext.class);

        Student xmlStudent1 = contextXml.getBean("student1", Student.class);
        Student xmlStudent2 = contextXml.getBean("student2", Student.class);
        Student xmlStudent3 = contextXml.getBean("student3", Student.class);

        Student javaStudent1 = contextJava.getBean("student1", Student.class);
        Student javaStudent2 = contextJava.getBean("student2", Student.class);
        Student javaStudent3 = contextJava.getBean("student3", Student.class);

        System.out.println("Xml students: ");
        System.out.println(xmlStudent1);
        System.out.println(xmlStudent2);
        System.out.println(xmlStudent3);

        System.out.println("\nJava students: ");
        System.out.println(javaStudent1);
        System.out.println(javaStudent2);
        System.out.println(javaStudent3);
    }
}
