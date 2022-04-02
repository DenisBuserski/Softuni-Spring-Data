package example;

import example.entities.Author;
import example.entities.Book;
import example.repositories.AuthorRepository;
import example.repositories.BookRepository;
import example.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

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

         this.booksAfter2000();

         this.allAuthorsWithBookBefore1990();

         this.allAuthorsOrderByBookCount();

         this.getBooksByAuthorFirstNameAndLastName("George Powell");

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
                .forEach(b ->
                        System.out.println(b.getTitle() + " - " + b.getReleaseDate() + " - " + b.getCopies()));

    }

    private void allAuthorsOrderByBookCount() {
        List<Author> authors = this.authorRepository.findAll();

        authors
                .stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(author ->
                        System.out.printf("%s %s -> %d%n",
                                author.getFirstName(),
                                author.getLastName(),
                                author.getBooks().size()));
    }

    private void allAuthorsWithBookBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 1, 1);
        List<Book> books = bookRepository.findByReleaseDateAfter(year2000);

        books.forEach(b -> System.out.println(b.getReleaseDate() + " " + b.getTitle()));
    }
}
