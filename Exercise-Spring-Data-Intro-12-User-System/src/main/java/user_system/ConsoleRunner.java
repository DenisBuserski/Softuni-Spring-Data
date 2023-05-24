package user_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user_system.entities.Album;
import user_system.entities.Town;
import user_system.entities.User;
import user_system.services.*;

import java.time.LocalDateTime;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final CountryService countryService;
    private final TownService townService;
    private final AlbumService albumService;
    private final PictureService pictureService;

    @Autowired
    public ConsoleRunner(UserService userService, CountryService countryService, TownService townService, AlbumService albumService, PictureService pictureService) {
        this.userService = userService;
        this.countryService = countryService;
        this.townService = townService;
        this.albumService = albumService;
        this.pictureService = pictureService;
    }


    @Override
    public void run(String... args) throws Exception {
//        addCountries();
//        addTowns();
//        addUsers();
//        addAlbums();
//        addPictures();
        printUserFirstAndLastName();




    }




    private void printUserFirstAndLastName() {
        System.out.println(this.userService.getUserFullNameById(1));
    }

    private void addUsers() {
        Town bornTown = this.townService.getTownByName("Sofia");
        Town currentlyLivingTown = this.townService.getTownByName("Pleven");
        this.userService.createUser("denis123", "password-test-1", "denis@mail.bg", LocalDateTime.now(), LocalDateTime.now(), 20, bornTown, currentlyLivingTown, "Denis", "Petrov");

        Town bornTown1 = this.townService.getTownByName("Sofia");
        Town currentlyLivingTown1 = this.townService.getTownByName("Varna");
        this.userService.createUser("alex4o", "password-test-2", "alex_dimitrov@gmail.com", LocalDateTime.now(), LocalDateTime.now(), 25, bornTown1, currentlyLivingTown1, "Alex", "Dimitrov");

        Town bornTown2 = this.townService.getTownByName("Sofia");
        Town currentlyLivingTown2 = this.townService.getTownByName("Burgas");
        this.userService.createUser("mimito", "password-test-3", "maria@mail.bg", LocalDateTime.now(), LocalDateTime.now(), 30, bornTown2, currentlyLivingTown2, "Maria", "Ivanov");

        Town bornTown3 = this.townService.getTownByName("Pleven");
        Town currentlyLivingTown3 = this.townService.getTownByName("New York");
        this.userService.createUser("ivan40", "password-test-4", "ivan.ivanov@abv.bg", LocalDateTime.now(), LocalDateTime.now(), 35, bornTown3, currentlyLivingTown3, "Ivan", "Ivanov");

        Town bornTown4 = this.townService.getTownByName("London");
        Town currentlyLivingTown4 = this.townService.getTownByName("New York");
        this.userService.createUser("pehata99", "password-test-5", "peshko@mail.bg", LocalDateTime.now(), LocalDateTime.now(), 40, bornTown4, currentlyLivingTown4, "Petar", "Vasilev");

        Town bornTown5 = this.townService.getTownByName("Paris");
        Town currentlyLivingTown5 = this.townService.getTownByName("Pleven");
        this.userService.createUser("sexxxypencho123", "password-test-6", "sexy-pencho@mymail.bg", LocalDateTime.now(), LocalDateTime.now(), 45, bornTown5, currentlyLivingTown5, "Pencho", "Traikov");

        Town bornTown6 = this.townService.getTownByName("Berlin");
        Town currentlyLivingTown6 = this.townService.getTownByName("Pleven");
        this.userService.createUser("pencheto", "password-test-7", "penka.penkova@abv.bg", LocalDateTime.now(), LocalDateTime.now(), 50, bornTown6, currentlyLivingTown6, "Penka", "Penkova");
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

    private void addAlbums() {
        User user = this.userService.getUserById(1);
        this.albumService.createAlbum("My album", "Blue", true, user);
        this.albumService.createAlbum("My album 1", "Red", false, user);
        this.albumService.createAlbum("My album 2", "Green", true, user);

        User user1 = this.userService.getUserById(2);
        this.albumService.createAlbum("My pics", "Yellow", true, user1);
        this.albumService.createAlbum("Private pics", "Brown", false, user1);

        User user2 = this.userService.getUserById(3);
        this.albumService.createAlbum("Sexy pics", "Black", false, user2);
    }

    private void addPictures() {
        Album album = this.albumService.getAlbumById(1);
        this.pictureService.createPicture("Pic-1", "Test-1", "Path-1", album);
        this.pictureService.createPicture("Pic-2", "Test-2", "Path-2", album);
        this.pictureService.createPicture("Pic-3", "Test-3", "Path-3", album);
        this.pictureService.createPicture("Pic-4", "Test-4", "Path-4", album);
        this.pictureService.createPicture("Pic-5", "Test-5", "Path-5", album);
    }

}
