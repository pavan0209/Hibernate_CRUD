package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.entity.Employee;

import java.util.Optional;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public Optional<Employee> fetchEmployee(int id) {
        return employeeDAO.getById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(Employee emp) {
        employeeDAO.delete(emp);
    }
}
