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
        addTowns();


//        this.userService.createUser("test-1", "password-test-1", "test@mail.bg", LocalDateTime.now(), LocalDateTime.now(), 20, null, null, "TestFirst1", "TestLast1");
//        System.out.println(this.userService.getUserFullName("TestFirst1", "TestLast1"));
    }

    private void addTowns() {
        this.townService.createTown("Sofia", this.countryService.getCountryByName("Bulgaria"));
        this.townService.createTown("Pleven", this.countryService.getCountryByName("Bulgaria"));
        this.townService.createTown("Varna", this.countryService.getCountryByName("Bulgaria"));
        this.townService.createTown("Burgas", this.countryService.getCountryByName("Bulgaria"));
        this.townService.createTown("Plovdiv", this.countryService.getCountryByName("Bulgaria"));
        this.townService.createTown("New York", this.countryService.getCountryByName("USA"));
        this.townService.createTown("Las Vegas", this.countryService.getCountryByName("USA"));
        this.townService.createTown("Miami", this.countryService.getCountryByName("USA"));
        this.townService.createTown("Newcastle", this.countryService.getCountryByName("England"));
        this.townService.createTown("Manchester", this.countryService.getCountryByName("England"));
        this.townService.createTown("Liverpool", this.countryService.getCountryByName("England"));
        this.townService.createTown("London", this.countryService.getCountryByName("England"));
        this.townService.createTown("Berlin", this.countryService.getCountryByName("Germany"));
        this.townService.createTown("Frankfurt", this.countryService.getCountryByName("Germany"));
        this.townService.createTown("Tokyo", this.countryService.getCountryByName("Japan"));
        this.townService.createTown("Paris", this.countryService.getCountryByName("France"));
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
