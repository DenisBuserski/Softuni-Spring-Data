package exercise.services;



import exercise.entities.Ingredient;
import exercise.entities.Shampoo;
import exercise.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeORLabelId(Size size, int labelId);

    List<Shampoo> selectMoreExpensiveThan(BigDecimal price);

    int countByPriceLowerThan(BigDecimal price);

    List<Shampoo> selectByIngredientCount(int count);

    List<String> findByIngredientsNames(List<String> names);
}
