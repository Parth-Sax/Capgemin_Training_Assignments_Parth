package org.example;
import java.util.*;
import java.sql.*;

public class Tasks {
    static Connection connection;
    static Statement statement;
    static Scanner sc = new Scanner(System.in);
    static boolean running = true;

    public static void main(String[] args) throws Exception{
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        // Create Connection
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbcTutorial",
                "root",
                "Parth@#rdbms"
        );

        // Create Statement
        statement = connection.createStatement();

        while(running) {
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    viewProductById();
                    break;
                case 4:
                    updateProductPrice();
                    break;
                case 5:
                    updateProductStock();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    static void addProduct() throws SQLException {
        int pid = sc.nextInt();
        sc.nextLine();
        String pname = sc.nextLine();
        String cat = sc.nextLine();
        double price = sc.nextDouble();
        int quantity = sc.nextInt();
        double rating = sc.nextDouble();
        String manufacturer = sc.nextLine();
        String query = "INSERT INTO products " +
                "(product_id, product_name, category, price, quantity, rating, manufacturer) VALUES (" +
                pid + ", '" +
                pname + "', '" +
                cat + "', " +
                price + ", " +
                quantity + ", " +
                rating + ", '" +
                manufacturer + "')";
        int rowsInserted = statement.executeUpdate(query);
        if(rowsInserted > 0) {
            System.out.println(rowsInserted + " row inserted");
        } else {
            System.out.println("Insert failed");
        }
    }
    static void viewProducts() throws Exception{
        ResultSet rs = statement.executeQuery("SELECT * FROM products");

        while(rs.next()) {
            int product_id = rs.getInt("product_id");
            String product_name = rs.getString("product_name");
            String category = rs.getString("category");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            double rating = rs.getDouble("rating");

            System.out.println(product_id + " | " + product_name + " | " + category + " | " + price + " | " + quantity + " | " + rating);
        }
    }

    static void viewProductById() {

        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            String query = "SELECT * FROM products WHERE product_id = " + id;

            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {

                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                double rating = rs.getDouble("rating");
                String manufacturer = rs.getString("manufacturer");
                Timestamp created_at = rs.getTimestamp("created_at");

                System.out.println("\n===== Product Details =====");
                System.out.println("ID: " + product_id);
                System.out.println("Name: " + product_name);
                System.out.println("Category: " + category);
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Rating: " + rating);
                System.out.println("Manufacturer: " + manufacturer);
                System.out.println("Created At: " + created_at);

            } else {
                System.out.println("Product does not exist.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid ID. Please enter a numeric value.");
            sc.nextLine(); // clear invalid input
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    static void updateProductPrice() {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            // 1️⃣ Check if product exists
            String checkQuery = "SELECT price FROM products WHERE product_id = " + id;
            ResultSet rs = statement.executeQuery(checkQuery);

            if (!rs.next()) {
                System.out.println("Product does not exist.");
                return;
            }

            // 2️⃣ Show old price
            double oldPrice = rs.getDouble("price");
            System.out.println("Current Price: " + oldPrice);

            // 3️⃣ Ask new price
            System.out.print("Enter New Price: ");
            double newPrice = sc.nextDouble();

            // 4️⃣ Validate
            if (newPrice <= 0) {
                System.out.println("Price must be greater than 0.");
                return;
            }

            // 5️⃣ Update only price field
            String updateQuery = "UPDATE products SET price = " + newPrice +
                    " WHERE product_id = " + id;

            int rowsUpdated = statement.executeUpdate(updateQuery);

            // 6️⃣ Show result
            if (rowsUpdated > 0) {
                System.out.println("Price updated successfully.");
                System.out.println("Rows affected: " + rowsUpdated);
            } else {
                System.out.println("Update failed.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct numeric values.");
            sc.nextLine(); // clear buffer
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    static void updateProductStock() {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            // 1️⃣ Check if product exists & get current quantity
            String checkQuery = "SELECT quantity FROM products WHERE product_id = " + id;
            ResultSet rs = statement.executeQuery(checkQuery);

            if (!rs.next()) {
                System.out.println("Product does not exist.");
                return;
            }

            int currentStock = rs.getInt("quantity");
            System.out.println("Current Stock: " + currentStock);

            // 2️⃣ Ask operation type
            System.out.println("Choose operation:");
            System.out.println("1. Increase Stock");
            System.out.println("2. Decrease Stock");
            int choice = sc.nextInt();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            if (qty < 0) {
                System.out.println("Quantity cannot be negative.");
                return;
            }

            int newStock = currentStock;

            // 3️⃣ Increase or Decrease
            if (choice == 1) {
                newStock = currentStock + qty;

            } else if (choice == 2) {
                newStock = currentStock - qty;

                // Prevent negative stock
                if (newStock < 0) {
                    System.out.println("Stock cannot become negative.");
                    return;
                }

            } else {
                System.out.println("Invalid choice.");
                return;
            }

            // 4️⃣ Update stock
            String updateQuery = "UPDATE products SET quantity = " + newStock +
                    " WHERE product_id = " + id;

            int rowsUpdated = statement.executeUpdate(updateQuery);

            if (rowsUpdated > 0) {
                System.out.println("Stock updated successfully.");
                System.out.println("Updated Stock: " + newStock);
            } else {
                System.out.println("Update failed.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            sc.nextLine(); // clear buffer
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    static void deleteQuery() {
        try {
            System.out.print("Enter Product ID to delete: ");
            int id = sc.nextInt();

            // Check if product exists
            String checkQuery = "SELECT product_id FROM products WHERE product_id = " + id;
            ResultSet rs = statement.executeQuery(checkQuery);

            if (!rs.next()) {
                System.out.println("Product does not exist.");
                return;
            }

            // Confirm deletion
            System.out.print("Are you sure you want to delete this product? (Y/N): ");
            sc.nextLine(); // clear buffer
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {

                String deleteQuery = "DELETE FROM products WHERE product_id = " + id;
                int rowsDeleted = statement.executeUpdate(deleteQuery);

                System.out.println("Rows affected: " + rowsDeleted);

            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
