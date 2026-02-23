package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // Add employee
        Employee employee = new Employee();
        employee.setId(104);
        employee.setName("Dipak");
        employee.setTechnology("PHP");

        service.addEmployee(employee);

        // Get
        Optional<Employee> retrieved = service.fetchEmployee(104);
        retrieved.ifPresent(emp -> System.out.println(retrieved.get()));

        // Update
        retrieved.ifPresent(emp -> {
            emp.setTechnology("Symphony");
            service.updateEmployee(emp);
        });

    }
}