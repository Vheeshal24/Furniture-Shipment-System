/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shippingsystem;

/**
 *
 * @author User
 */
public class Admin extends Employee {

    public Admin(String employeeID, String employeeName, String role, String contactInfo) {
        super.setEmployeeID(employeeID);
        super.setEmployeeName(employeeName);
        super.setRole(role);
        super.setContactInfo(contactInfo);
    }

    @Override
    public void performTask() {
        System.out.println("Admin task execution");
    }

    public void addEmployee(Employee employee) {
        ShippingSystem.addEmployee(employee);
        System.out.println("Employee " + employee.getEmployeeName() + " added by Admin " + this.getEmployeeName());
    }

    public void removeEmployee(String employeeID) {
        Employee employee = ShippingSystem.getEmployeeById(employeeID);
        if (employee != null) {
            ShippingSystem.removeEmployee(employeeID);
            System.out.println("Employee " + employee.getEmployeeName() + " removed by Admin " + this.getEmployeeName());
        } else {
            System.out.println("Employee with ID " + employeeID + " not found.");
        }
    }

    public void updateEmployeeInfo(String employeeID, String newName, String newRole, String newContactInfo) {
        Employee employee = ShippingSystem.getEmployeeById(employeeID);
        if (employee != null) {
            employee.setEmployeeName(newName);
            employee.setRole(newRole);
            employee.setContactInfo(newContactInfo);
            System.out.println("Employee " + employee.getEmployeeName() + " info updated by Admin " + this.getEmployeeName());
        } else {
            System.out.println("Employee with ID " + employeeID + " not found.");
        }
    }
}
