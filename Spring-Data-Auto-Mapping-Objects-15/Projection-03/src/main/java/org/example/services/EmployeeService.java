package org.example.services;

import org.example.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findEmployeesBornBefore(int year);

    void save(Employee employee);
}
