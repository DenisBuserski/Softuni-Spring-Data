package org.example.repository;

import org.example.model.entity.AgeRestriction;
import org.example.model.entity.Book;
import org.example.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b.title " +
            " FROM Book b " +
            " WHERE b.editionType LIKE :editionType" +
            " AND b.copies <= :copies")
    List<String> findAllTitlesByEditionTypeAndCopiesLessThan(
            @Param("editionType") EditionType editionType,
            @Param("copies") int copies);
}
