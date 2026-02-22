package org.example.dao;

import org.example.entity.Employee;

import java.util.Optional;

public interface EmployeeDAO {

    public void save(Employee employee);

    public Optional<Employee> getById(int id);
}
