package shampoo_company.services;

import shampoo_company.entities.Ingredient;
import java.util.List;

public interface IngredientService {

    List<Ingredient> selectNameStartsWith(String letter); // 04

    List<Ingredient> selectInNames(List<String> names); // 05

    int deleteByName(String name); // 09

    void increasePriceByPercentage(double percent); // 10

    void increasePriceOfIngredients(List<String> ingredients); // 11

}
