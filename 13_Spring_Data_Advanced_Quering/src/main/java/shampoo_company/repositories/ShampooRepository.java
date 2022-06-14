package shampoo_company.repositories;

import shampoo_company.entities.Shampoo;
import shampoo_company.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    @Query("SELECT DISTINCT s.brand " +
            " FROM Shampoo AS s" +
            " JOIN s.ingredients AS i" +
            " WHERE i.name IN :ingredientNames")
    List<String> findByIngredients( // 07
            @Param("ingredientNames") List<String> ingredientNames);

    List<Shampoo> findBySize(Size size); // 01

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, long labelId); // 02

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price); // 03

    int countByPriceLessThan(BigDecimal price); // 06

    @Query("SELECT s FROM Shampoo s" +
            " WHERE s.ingredients.size < :count")
    List<Shampoo> findByIngredientCountLessThan(int count); // 08
}
