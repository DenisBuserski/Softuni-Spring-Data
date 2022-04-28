package exercise.repositories;

import exercise.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ingredient AS b WHERE b.name = :name")
    int deleteByName(String name);


    @Modifying
    @Query("UPDATE Ingredient i " +
            " SET i.price = (i.price * :multiplier) + i.price")
    void increasePriceByPercent(@Param("multiplier") BigDecimal percent);

    List<Ingredient> findByNameIn(List<String> names);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient i " +
            " SET i.price = i.price + 10" +
            " WHERE i.name IN :ingredientNames")
    void increasePriceOfIngredients(@Param("ingredientNames")List<String> ingredients);

}
