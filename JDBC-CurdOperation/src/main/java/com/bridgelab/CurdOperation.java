package com.bridgelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurdOperation {
    String URL = "jdbc:mysql://localhost:3306/JDBC";
   String USERNAME = "root";
    String PASSWORD = "Savita@123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void createTable() {
    	
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS employeee (id INT PRIMARY KEY, name VARCHAR(255), salary DECIMAL(10, 2))")) {
            statement.executeUpdate();
            System.out.println("Table 'employeee' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRecord(int id,String name, double salary) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employeee (id, name, salary) VALUES (?, ?, ?)")) {
            
            statement.setInt(1, id);
            
        	statement.setString(2, name);
            statement.setDouble(3, salary);
            
            statement.executeUpdate();
            System.out.println("Record created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void readRecord(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeee WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(int id, String newName, double newSalary) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE employeee SET name = ?, salary = ? WHERE id = ?")) {
            statement.setString(1, newName);
            statement.setDouble(2, newSalary);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Record updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employeee WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
