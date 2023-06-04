package shampoo.serivices;

import shampoo.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectNameStartsWith(String letter);
}
