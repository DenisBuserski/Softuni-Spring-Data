package org.example;

import org.example.entities.Employee;
import org.example.entities.dto.EmployeeDTO;
import org.example.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

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

        Optional<Employee> managerOption = this.employeeService.findOneById(1);
        Employee managerRes = managerOption.get();

        ModelMapper mapper = new ModelMapper();
        EmployeeDTO employeeDTO = mapper.map(managerRes, EmployeeDTO.class);
        System.out.println(employeeDTO.toString());
    }
}
