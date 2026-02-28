package callable_and_storedpro_and_properties;

public class MainApp {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        service.insertEmployee("weer", 123.23);
    }
}
