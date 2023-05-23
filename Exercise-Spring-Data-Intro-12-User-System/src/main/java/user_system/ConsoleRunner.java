package user_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user_system.services.CountryService;
import user_system.services.TownService;
import user_system.services.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final CountryService countryService;
    private final TownService townService;

    @Autowired
    public ConsoleRunner(UserService userService, CountryService countryService, TownService townService) {
        this.userService = userService;
        this.countryService = countryService;
        this.townService = townService;
    }


    @Override
    public void run(String... args) throws Exception {
        addCountries();

        this.townService.createTown("Sofia", this.countryService.getCountryByName("Bulgaria"));



//        this.userService.createUser("test-1", "password-test-1", "test@mail.bg", LocalDateTime.now(), LocalDateTime.now(), 20, null, null, "TestFirst1", "TestLast1");
//        System.out.println(this.userService.getUserFullName("TestFirst1", "TestLast1"));
    }

    private void addCountries() {
        this.countryService.createCountry("Bulgaria");
        this.countryService.createCountry("Russia");
        this.countryService.createCountry("USA");
        this.countryService.createCountry("England");
        this.countryService.createCountry("Brazil");
        this.countryService.createCountry("France");
        this.countryService.createCountry("Japan");
        this.countryService.createCountry("China");
        this.countryService.createCountry("Germany");
        this.countryService.createCountry("Canada");
    }
}
