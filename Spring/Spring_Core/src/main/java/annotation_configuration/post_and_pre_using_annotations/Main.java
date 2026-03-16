package annotation_configuration.post_and_pre_using_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.ObjectInputFilter;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ObjectInputFilter.Config.class);
        Vehicle vehicle = applicationContext.getBean(Vehicle.class);
        ((AbstractApplicationContext) applicationContext).close();
    }
}
