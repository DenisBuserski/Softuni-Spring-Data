package org.example;

import org.example.entities.Employee;
import org.example.entities.dto.CustomDTO;
import org.example.entities.dto.EmployeeDTO;
import org.example.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee manager = new Employee("MANAGER-FIRST-NAME", "MANGER-LAST-NAME", BigDecimal.valueOf(50000), LocalDate.of(1989, 1, 1), null);
        Employee employee1 = new Employee("Employee-1", "LastNameEM-1", BigDecimal.valueOf(1000), LocalDate.of(1980, 1, 1), manager);
        Employee employee2 = new Employee("Employee-2", "LastNameEM-2", BigDecimal.valueOf(2000), LocalDate.of(1950, 1, 1), manager);
        Employee employee3 = new Employee("Employee-3", "LastNameEM-3", BigDecimal.valueOf(3000), LocalDate.now(), manager);
        Employee employee4 = new Employee("Employee-4", "LastNameEM-4", BigDecimal.valueOf(4000), LocalDate.of(1970, 1, 1), null);
        Employee employee5 = new Employee("Employee-5", "LastNameEM-5", BigDecimal.valueOf(5000), LocalDate.now(), null);

        System.out.println("Please select number:");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1 -> save(manager, employee1, employee2, employee3, employee4, employee5);
            case 2 -> findEmployeesBornBefore1990();
            case 3 -> customDTO();
        }
    }

    private void customDTO() {
        ModelMapper mapper = new ModelMapper();
        List<Employee> employees = this.employeeService.findAll();

        TypeMap<Employee, CustomDTO> employeeToCustom =
                mapper.typeMap(Employee.class, CustomDTO.class)
                        .addMappings(m -> m.map(
                                        source -> {
                                            Employee manager = source.getManager();
                                            if (manager == null) {
                                                return 0;
                                            }
                                            return source.getManager().getLastName().length();
                                        }, (CustomDTO customDTO, Integer mangerLastNameLength) -> customDTO.setMangerLastNameLength(mangerLastNameLength)));
                                        

        employees
                .stream()
                .map(employeeToCustom::map)
                .forEach(System.out::println);

    }

    private void findEmployeesBornBefore1990() {
        ModelMapper mapper = new ModelMapper();
        List<EmployeeDTO> list = this.employeeService.findEmployeesBornBefore(1990);
        list.stream().map(e -> mapper.map(e, EmployeeDTO.class)).forEach(System.out::println);
    }

    private void save(Employee manager, Employee employee1, Employee employee2, Employee employee3, Employee employee4, Employee employee5) {
        // this.employeeService.save(employee1);
        // Insert employee1 with manager in the DB if I have (cascade = CascadeType.ALL) on
        // @ManyToOne
        // private Employee manager;

        this.employeeService.save(manager);
        this.employeeService.save(employee1);
        this.employeeService.save(employee2);
        this.employeeService.save(employee3);
        this.employeeService.save(employee4);
        this.employeeService.save(employee5);
    }
}
