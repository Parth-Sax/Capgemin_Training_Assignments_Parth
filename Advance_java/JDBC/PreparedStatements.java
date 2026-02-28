package prepared_statement;
import java.util.*;
import java.sql.*;


public class PreparedStatements {
    public static void main(String[] args) throws Exception {
        // 1) load and register driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        // 2) create connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbcTutorial",
                "root",
                "Parth@#rdbms"
        );

        // 3) ================insert================
        String insertQuery = "INSERT INTO player VALUES (?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(insertQuery);

        pst.setInt(1, 3); // id
        pst.setString(2, "Warner"); // name
        pst.setString(3, "AUS"); // country

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println(rowsInserted + " row inserted");
        } else {
            System.out.println("insert failed");
        }

        // ============update============
        String updateQuery = "UPDATE player SET country = ? WHERE id = ?";

        PreparedStatement updateStmt = connection.prepareStatement(updateQuery);

        updateStmt.setString(1, "England"); // new country
        updateStmt.setInt(2, 3); // id

        int rowsUpdated = updateStmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println(rowsUpdated + " row updated");
        } else
            System.out.println("update failed");
        }


        // 5) ================delete=======================
        String deleteQuery = "DELETE FROM player WHERE id = ?";
        PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
        deleteStmt.setInt(1, 3);
        int rowsDeleted = deleteStmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println(rowsDeleted + " rows deleted");
        } else {
            System.out.println("delete failed");
        }
    }
}
