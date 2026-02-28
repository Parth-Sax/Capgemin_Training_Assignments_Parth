package callable_and_storedpro_and_properties;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private int id;
    private String name;
    private double salary;
}
