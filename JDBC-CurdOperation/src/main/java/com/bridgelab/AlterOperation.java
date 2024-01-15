package com.bridgelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlterOperation {

    private Connection getConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/JDBC";
        String USERNAME = "root";
        String PASSWORD = "Savita@123";
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void alterTableAddAddressColumn() {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("ALTER TABLE employeee ADD COLUMN State VARCHAR(255)")) {
            statement.executeUpdate();
            System.out.println("Table 'employeee' altered successfully. Added column: address1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
