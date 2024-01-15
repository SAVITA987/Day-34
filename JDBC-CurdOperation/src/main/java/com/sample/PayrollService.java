package com.sample;
import com.sample.EmployeePayroll;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
public class PayrollService {

	    public List<EmployeePayroll> getAllEmployeePayroll() throws SQLException {
	        List<EmployeePayroll> employeePayrolls = new ArrayList<>();
	        PayrollService payrollService = new PayrollService(); // Ensure that payrollService is initialized

	        try (Connection connection = DatabaseConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")) {

	            while (resultSet.next()) {
	                EmployeePayroll employeePayroll = new EmployeePayroll();
	                employeePayroll.setId(resultSet.getInt("id"));
	                employeePayroll.setName(resultSet.getString("name"));
	                employeePayroll.setSalary(resultSet.getDouble("salary"));
	                employeePayroll.setStart_date(resultSet.getDate("start_date"));
	                // Populate other fields as needed
	                employeePayrolls.add(employeePayroll);
	            }
	        }

	        return employeePayrolls;
	    }

  
public void updateSalaryForTerisa(double newSalary) throws SQLException {
    try (Connection connection = DatabaseConnection.getConnection();
         Statement statement = connection.createStatement()) {

        String updateQuery = "UPDATE employee SET salary = " + newSalary + " WHERE name = 'Viraj'";
        int rowsAffected = statement.executeUpdate(updateQuery);

        if (rowsAffected > 0) {
        } else {
            throw new Exception("Terisa not found or salary update failed");
        }
    } catch (Exception e) {
		e.printStackTrace();
	}
}
public void updateSalaryForTerisaPreparedStatement(double newSalary) throws SQLException {
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET salary = ? WHERE name = 'Viraj'")) {

        preparedStatement.setDouble(1, newSalary);
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
          
        } else {
            throw new Exception("Viraj not found or salary update failed");
        }
    } catch (Exception e) {
		
		e.printStackTrace();
	}
}
public List<EmployeePayroll> getEmployeesByDateRange(java.sql.Date startDate, java.sql.Date endDate) throws SQLException {
    List<EmployeePayroll> employeePayrolls = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE start_date BETWEEN ? AND ?")) {

        preparedStatement.setDate(1, startDate);
        preparedStatement.setDate(2, endDate);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                EmployeePayroll employeePayroll = new EmployeePayroll();
                employeePayrolls.add(employeePayroll);
            }
        }
    }

    return employeePayrolls;
}
public void analyzeEmployeeData() throws SQLException {
    try (Connection connection = DatabaseConnection.getConnection();
         Statement statement = connection.createStatement()) {

        String query = "SELECT SUM(salary), AVG(salary), MIN(salary), MAX(salary), COUNT(*) " +
                "FROM employee GROUP BY gender";
        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                double sum = resultSet.getDouble(1);
                double average = resultSet.getDouble(2);
                double min = resultSet.getDouble(3);
                double max = resultSet.getDouble(4);
                int count = resultSet.getInt(5);

               
            }
        }
    }
}

public List<EmployeePayroll> getEmployeesByDateRange(String startDate, String endDate) {
	
	return null;
}

}


