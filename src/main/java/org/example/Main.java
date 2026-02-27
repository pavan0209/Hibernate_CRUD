package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // Add employee
        Employee employee = new Employee();
        employee.setName("Arpit");
        employee.setTechnology("Service Now");

        service.addEmployee(employee);

        // Get
        Optional<Employee> retrieved = service.fetchEmployee(103);
        retrieved.ifPresent(emp -> System.out.println(retrieved.get()));

        // Update
        retrieved.ifPresent(emp -> {
            emp.setTechnology("Symphony");
            service.updateEmployee(emp);
        });

        // Delete
        retrieved.ifPresent(emp -> {
            service.deleteEmployee(emp);
//            System.out.println("Deleted employee" + emp);
        });
    }
}