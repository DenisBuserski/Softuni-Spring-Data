package shampoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shampoo.entities.Ingredient;
import shampoo.entities.Shampoo;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    int deleteByName(String name);

    @Modifying
    @Query("UPDATE Ingredient i " +
            " SET i.price = i.price + i.price * :multiplier")
    int increasePriceByPercent(
            @Param("multiplier") BigDecimal percent);
}
