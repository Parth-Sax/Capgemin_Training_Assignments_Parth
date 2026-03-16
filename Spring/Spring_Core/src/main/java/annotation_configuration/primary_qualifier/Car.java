package annotation_configuration.primary_qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("Car running");
    }

}

