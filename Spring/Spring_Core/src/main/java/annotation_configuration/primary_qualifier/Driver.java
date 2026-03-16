package annotation_configuration.primary_qualifier;

import annotation_configuration.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    @Autowired
    @Qualifier(value = "bike")
    private Vehicle vehicle;

    public void drive() {
        vehicle.run();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver driver = context.getBean(Driver.class);
        driver.drive();
    }
}
