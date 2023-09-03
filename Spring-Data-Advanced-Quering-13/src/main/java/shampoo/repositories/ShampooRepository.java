package shampoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shampoo.entities.Shampoo;
import shampoo.enums.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findAllByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, long label);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    List<Shampoo> findShampooByIngredientsIn(List<String> names);

    @Query("SELECT s " +
            " FROM Shampoo s " +
            " WHERE s.ingredients.size < :count")
    List<Shampoo> findByIngredientCountLessThan(int count);

    @Query("SELECT DISTINCT(s.brand) FROM Shampoo s " +
            " JOIN s.ingredients AS i " +
            " WHERE i.name IN :ingredientNames")
    List<String> findByIngredientsNames(
            @Param("ingredientNames") List<String> ingredientNames);
}
