package com.example.jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Create a new employee
        Employee newEmployee = new Employee(1, "Vasundara", "vasu@gmail.com", 90000.0);
        employeeDAO.createEmployee(newEmployee);

        // Read all employees
        System.out.println("\nAll Employees:");
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Update an employee (assuming ID 1 exists)
        Employee updateEmployee = new Employee(1, "Vasundara Updated", "vasumathi@gmail.com", 120000.0);
        employeeDAO.updateEmployee(updateEmployee);

        // Delete an employee (assuming ID 2 exists)
        employeeDAO.deleteEmployee(2);

        // Show updated list
        System.out.println("\nUpdated Employee List:");
        employees = employeeDAO.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}