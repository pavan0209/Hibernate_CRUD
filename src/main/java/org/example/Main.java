package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // Add employee
        Employee employee = new Employee();
        employee.setId(102);
        employee.setName("Ganesh");
        employee.setTechnology("Angular");

        service.addEmployee(employee);

    }
}