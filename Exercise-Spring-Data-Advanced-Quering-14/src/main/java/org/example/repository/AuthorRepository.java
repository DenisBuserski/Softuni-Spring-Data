package org.example.repository;

import org.example.model.entity.Author;
import org.example.model.entity.AuthorNamesWithTotalCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameLike(String input);

    @Query("SELECT a, SUM(b.copies) AS totalCopies" +
            " FROM Author a " +
            " JOIN a.books AS b " +
            " GROUP BY b.author " +
            " ORDER BY totalCopies")
    List<AuthorNamesWithTotalCopies> getWithTotalCopies();

}
