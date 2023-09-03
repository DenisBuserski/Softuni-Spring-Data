package shampoo.serivices;

import shampoo.entities.Shampoo;
import shampoo.enums.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> selectBySizeOrLabelId(Size size, int labelId);

    List<Shampoo> selectMoreExpensiveThan(BigDecimal price);

    int countPriceLowerThan(BigDecimal price);

    List<Shampoo> findByIngredientsIn(List<String> names);

    List<Shampoo> selectByIngredientsCount(int count);

    List<String> findByIngredientsNames(List<String> ingredientNames);
}
