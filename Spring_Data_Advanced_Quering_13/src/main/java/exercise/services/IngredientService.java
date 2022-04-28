package exercise.services;

import exercise.entities.Ingredient;
import java.util.List;

public interface IngredientService {

    List<Ingredient> selectNameStartsWith(String letter);

    List<Ingredient> selectInNames(List<String> names);

    int deleteByName(String name);

    void increasePriceByPercentage(double percent);

    void increasePriceOfIngredients(List<String> ingredients);

}
