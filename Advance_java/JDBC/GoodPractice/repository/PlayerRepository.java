package com.capge.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlayerRepository {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbcTutorial",
                    "root",
                    "Parth@#rdbms"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
