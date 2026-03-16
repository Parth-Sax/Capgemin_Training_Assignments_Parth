package annotation_configuration.entity;

import annotation_configuration.configuration.AppConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    @Value("100")
    private int id;
//    @Value(value = "ABC")
    private String name = "ABC";
    private int rollNo = 123;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student s = context.getBean(Student.class);
        System.out.println(s);
    }
}
