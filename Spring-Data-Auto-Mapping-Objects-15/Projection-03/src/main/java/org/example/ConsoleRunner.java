package org.example;

import org.example.entities.Employee;
import org.example.entities.dto.CustomDTO;
import org.example.entities.dto.EmployeeDTO;
import org.example.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee manager = new Employee("MANAGER-FIRST-NAME", "MANGER-LAST-NAME", BigDecimal.valueOf(50000), LocalDate.of(1989,1,1), null);
        Employee employee1 = new Employee("Employee-1", "LastNameEM", BigDecimal.valueOf(1000), LocalDate.of(1980,1,1), manager);
        Employee employee2 = new Employee("Employee-2", "LastNameEM1", BigDecimal.valueOf(2000), LocalDate.of(1950,1,1), manager);
        Employee employee3 = new Employee("Employee-3", "LastNameEM1", BigDecimal.valueOf(3000), LocalDate.now(), manager);
        Employee employee4 = new Employee("Employee-4", "LastNameEM1", BigDecimal.valueOf(4000), LocalDate.of(1970,1,1), null);
        Employee employee5 = new Employee("Employee-5", "LastNameEM1", BigDecimal.valueOf(5000), LocalDate.now(), null);

        this.employeeService.save(manager);

//        ModelMapper mapper = new ModelMapper();
//        List<EmployeeDTO> list = this.employeeService.findEmployeesBornBefore(1990);
//        list.stream().map(e -> mapper.map(e, EmployeeDTO.class)).forEach(System.out::println);

//        this.employeeService.findEmployeesBornBefore(1990).forEach(System.out::println);


//        ModelMapper mapper = new ModelMapper();
//        List<Employee> all = this.employeeService.findAll();
//        all.stream().map(e -> mapper.map(e, CustomDTO.class)).forEach(System.out::println);


    }
}
