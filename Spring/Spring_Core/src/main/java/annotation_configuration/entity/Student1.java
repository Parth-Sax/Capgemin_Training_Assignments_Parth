package annotation_configuration.entity;

import annotation_configuration.configuration.AppConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student1 {
    @Value("${id}")
    private int id;

    @Value("${name}")
    private String name;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student1 s1 = context.getBean(Student1.class);
        System.out.println(s1);
    }
}
