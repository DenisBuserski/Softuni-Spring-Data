package shampoo.serivices;

import shampoo.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
    List<Ingredient> selectNameStartsWith(String letter);

    List<Ingredient> selectInNames(List<String> names);


    int deleteByName(String name);

    int increasePriceByPercentage(BigDecimal percent);

    int updatePriceForGivenNames(List<String> ingredientNames);

    Ingredient findByName(String name);
}
