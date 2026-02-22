package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOImpl;
import org.example.entity.Employee;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }
}
