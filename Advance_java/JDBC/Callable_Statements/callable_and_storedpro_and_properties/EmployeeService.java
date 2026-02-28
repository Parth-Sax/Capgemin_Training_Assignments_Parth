package callable_and_storedpro_and_properties;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public void insertEmployee(String name, double salary) {
        String sql = "{CALL InsertEmployee(?, ?)}"; // calling stored procedure

        try (Connection conn = DatabaseUtil.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, name);
            stmt.setDouble(2,salary);
            stmt.execute();
            System.out.println("Employee inserted successfully");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // retrieve Employees using CallableStatement
//    public List<Employee> getAllEmployees() {
//        List<Employee> employees = new ArrayList<>();
//    }

}
