


package com.example.jdbc;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // Create an employee
    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setDouble(3, employee.getSalary());
            
            pstmt.executeUpdate();
            System.out.println("Employee created successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Read all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Employee employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getDouble("salary")
                );
                employees.add(employee);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employees;
    }
    
    // Update an employee
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, email = ?, salary = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setInt(4, employee.getId());
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Delete an employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Helper method to get database connection
    private Connection getConnection() throws SQLException {
        try {
            Class.forName(DatabaseConfig.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
            DatabaseConfig.URL,
            DatabaseConfig.USERNAME,
            DatabaseConfig.PASSWORD
        );
    }
}
