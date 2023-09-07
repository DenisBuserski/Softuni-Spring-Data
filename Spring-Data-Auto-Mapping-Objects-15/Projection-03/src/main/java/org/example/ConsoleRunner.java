package org.example;

import org.example.entities.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee manager = new Employee("FirstNameMAN", "LastNameMAN", BigDecimal.TEN, LocalDate.now(), null);
        Employee employee = new Employee("FistNameEm", "LastNameEM", BigDecimal.ONE, LocalDate.now(), manager);
        Employee employee1 = new Employee("FistNameEm1", "LastNameEM1", BigDecimal.ONE, LocalDate.now(), manager);

        this.employeeService.save(manager);
    }
}
