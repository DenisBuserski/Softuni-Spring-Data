package shampoo_company.services;



import shampoo_company.entities.Shampoo;
import shampoo_company.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size); // 01

    List<Shampoo> selectBySizeORLabelId(Size size, int labelId); // 02

    List<Shampoo> selectMoreExpensiveThan(BigDecimal price); // 03

    int countByPriceLowerThan(BigDecimal price); // 06

    List<Shampoo> selectByIngredientCount(int count); // 08

    List<String> findByIngredientsNames(List<String> names); // 07
}
