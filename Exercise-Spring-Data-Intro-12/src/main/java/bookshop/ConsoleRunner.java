package bookshop;

import bookshop.entities.Book;
import bookshop.repositories.AuthorRepository;
import bookshop.repositories.BookRepository;
import bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(
            SeedService seedService,
            BookRepository bookRepository,
            AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAuthors();
        this.seedService.seedCategories();
        this.seedService.seedBooks();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("Exit")) {
            switch (input) {
                case "1":
                    this.booksAfter2000();
                    break;
                case "2":
                    this.allAuthorsWithBookBefore1990();
                    break;
                case "3":
                    this.allAuthorsOrderByBookCount();
                    break;
                case "4":
                    this.getBooksByAuthorFirstNameAndLastName("George Powell");
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private void getBooksByAuthorFirstNameAndLastName(String authorName) {
        String firstName = authorName.split("\\s+")[0];
        String lastName = authorName.split("\\s+")[1];

        this.bookRepository
                .findAll()
                .stream()
                .filter(book -> book.getAuthor().getFirstName().equals(firstName) &&
                        book.getAuthor().getLastName().equals(lastName))
                .sorted(Comparator.comparing(Book::getTitle))
                .sorted((l, r) -> r.getReleaseDate().compareTo(l.getReleaseDate()))
                .forEach(b -> System.out.println(b.getTitle() + " - " + b.getReleaseDate() + " - " + b.getCopies()));
    }

    private void allAuthorsOrderByBookCount() {
        this.authorRepository
                .findAll()
                .stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(author -> System.out.printf("%s %s -> %d%n",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()));
    }

    private void allAuthorsWithBookBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990)
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 1, 1);
        bookRepository.findByReleaseDateAfter(year2000)
                .forEach(b -> System.out.println(b.getReleaseDate() + " " + b.getTitle()));
    }
}
