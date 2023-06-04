package shampoo.serivices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shampoo.entities.Ingredient;
import shampoo.repositories.IngredientRepository;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectNameStartsWith(String letter) {
        return this.ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> selectInNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPriceAsc(names);
    }
}
