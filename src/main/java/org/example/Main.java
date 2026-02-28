package org.example;

import org.example.entity.Employee;
import org.example.entity.Workstation;
import org.example.service.EmployeeService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // Add employee
        Employee employee = new Employee();
        employee.setName("Pavan");
        employee.setTechnology("SpringBoot");

        Workstation workstation = new Workstation();
        workstation.setDeskNumber("A-12");
        workstation.setPcSerialNumber("MAC-01-2043");

        employee.setWorkstation(workstation);

        service.addEmployee(employee);

        // Get
        Optional<Employee> retrieved = service.fetchEmployee(3);
        retrieved.ifPresent(emp -> System.out.println(retrieved.get()));

        // Update
        retrieved.ifPresent(emp -> {
            emp.setName("Rushi");
            emp.setTechnology("React JS");
            Workstation station = emp.getWorkstation();
            station.setDeskNumber("A-5");
            station.setPcSerialNumber("HP-09-2398");
            emp.setWorkstation(station);
            service.updateEmployee(emp);
        });

        // Delete
        retrieved.ifPresent(emp -> {
//            service.deleteEmployee(emp);
        });
    }
}