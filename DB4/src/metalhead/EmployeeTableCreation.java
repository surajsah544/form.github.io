package metalhead;

import java.sql.*;

public class EmployeeTableCreation {
    // JDBC URL, username, and password of the database
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/DB4";
    static final String USERNAME = "root";
    static final String PASSWORD = "surajsah123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create a statement
            Statement statement = conn.createStatement();

            // Create the employee table
            String createTableSQL = "CREATE TABLE employee (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INT," +
                    "position VARCHAR(50)," +
                    "salary DECIMAL(10, 2)" +
                    ")";
            statement.executeUpdate(createTableSQL);
            System.out.println("Employee table created successfully.");

            // Insert values into the employee table
            String insertSQL = "INSERT INTO employee (name, age, position, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
            // Insert employee 1
            preparedStatement.setString(1, "John Doe");
            preparedStatement.setInt(2, 30);
            preparedStatement.setString(3, "Software Engineer");
            preparedStatement.setDouble(4, 75000.00);
            preparedStatement.executeUpdate();
            // Insert employee 2
            preparedStatement.setString(1, "Jane Smith");
            preparedStatement.setInt(2, 28);
            preparedStatement.setString(3, "Product Manager");
            preparedStatement.setDouble(4, 90000.00);
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "Suraj Sah");
            preparedStatement.setInt(2, 28);
            preparedStatement.setString(3, "java developer");
            preparedStatement.setDouble(4, 90000.00);
            preparedStatement.executeUpdate();

            System.out.println("Values inserted into the employee table successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

