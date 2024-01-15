package com.sample;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            PayrollService payrollService = new PayrollService(); 
            List<EmployeePayroll> allEmployeePayroll = payrollService.getAllEmployeePayroll();
            System.out.println("All Employee Payroll Data:");
            for (EmployeePayroll employeePayroll : allEmployeePayroll) {
                System.out.println(employeePayroll);
            }
            
            double newSalary = 3000000.00;
            payrollService.updateSalaryForTerisa(newSalary);
            
            payrollService.updateSalaryForTerisaPreparedStatement(newSalary);
            String startDate  = "";
            String endDate  = "";

            List<EmployeePayroll> employeesByDateRange = payrollService.getEmployeesByDateRange(startDate, endDate);

            if (employeesByDateRange != null) {
                Iterator<EmployeePayroll> iterator = employeesByDateRange.iterator();
                while (iterator.hasNext()) {
                    EmployeePayroll employee = iterator.next();
                    System.out.println(employee.getName());
                }
            } else {
                System.out.println("employeesByDateRange is null.");
            }
            payrollService.analyzeEmployeeData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
