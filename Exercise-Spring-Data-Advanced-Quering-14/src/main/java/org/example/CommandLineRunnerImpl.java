package org.example;

import org.example.model.entity.Book;
import org.example.model.entity.EditionType;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Please select exercise:");
        Scanner scanner = new Scanner(System.in);
        int exercise = Integer.parseInt(scanner.nextLine());
        switch (exercise) {
            case 1 -> booksTitlesByAgeRestriction01(scanner);
            case 2 -> goldenBooks02();
            case 3 -> booksByPrice03();
            case 4 -> notReleasedBooks04(scanner);
            case 5 -> booksReleasedBeforeDate05(scanner);
        }


        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
        // pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }
    
    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void booksTitlesByAgeRestriction01(Scanner scanner) {
        String ageRestriction = scanner.nextLine().toUpperCase();
        this.bookService.findAllTitlesByAgeRestriction(ageRestriction).forEach(System.out::println);
    }

    private void goldenBooks02() {
        this.bookService.findAllTitlesByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000).forEach(System.out::println);
    }

    private void booksByPrice03() {
        this.bookService.findAllTitlesAndPriceBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(book -> System.out.println(book.getTitle() + " - " + book.getPrice()));
    }

    private void notReleasedBooks04(Scanner scanner) {
        int year = Integer.parseInt(scanner.nextLine());
        this.bookService.findTitlesByYearNotIn(year).forEach(System.out::println);
    }

    private void booksReleasedBeforeDate05(Scanner scanner) {

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
