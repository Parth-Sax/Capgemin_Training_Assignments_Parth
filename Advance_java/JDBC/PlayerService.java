package org.example;
import java.sql.*;
import java.util.*;

public class PlayerService {
    public static void main(String[] args) throws Exception{
        // 1) load and register driver
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        // 2) create connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbcTutorial",
                "root",
                "Parth@#rdbms"
        );

        // 3) create statement
        Statement statement = connection.createStatement();

        // 4) ============INSERT================
        int rowsInserted = statement.executeUpdate(
                "INSERT INTO players " +
                        "(player_name, age, country, team, role, matches_played, runs_scored, wickets_taken) " +
                        "VALUES ('Virat Kohli', 35, 'India', 'RCB', 'Batsman', 250, 12000, 4)"
        );
        if(rowsInserted > 0) {
            System.out.println(rowsInserted + " row inserted");
        } else {
            System.out.println("Insert failed");
        }

        // ===============FETCH==============
        ResultSet rs = statement.executeQuery("SELECT * FROM players");

        while(rs.next()) {
            int id = rs.getInt("player_id");
            String name = rs.getString("player_name");
            String country = rs.getString("country");

            System.out.println(id + " | " + name + " | " + country);
        }

        // 5) Close connection
        connection.close();

        // 6) ===========UPDATE=========
        int rowsUpdated = statement.executeUpdate(
                "UPDATE players SET country = 'England' WHERE player_id = 2"
        );
        if(rowsUpdated > 0) {
            System.out.println(rowsUpdated + " row updated");
        } else {
            System.out.println("Update failed");
        }

        // 7) =========DELETE============
        int rowsDeleted = statement.executeUpdate(
                "DELETE FROM players WHERE player_id = 2"
        );
        if(rowsDeleted > 0) {
            System.out.println(rowsDeleted + " row deleted");
        } else {
            System.out.println("Delete failed");
        }
    }
}
