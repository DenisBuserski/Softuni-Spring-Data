package shampoo.serivices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shampoo.entities.Ingredient;
import shampoo.entities.Shampoo;
import shampoo.repositories.IngredientRepository;
import shampoo.repositories.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final ShampooRepository shampooRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, ShampooRepository shampooRepository) {
        this.ingredientRepository = ingredientRepository;
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Ingredient> selectNameStartsWith(String letter) {
        return this.ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> selectInNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        Ingredient ingredient = this.ingredientRepository.findByName(name);
        List<Shampoo> shampoos = this.shampooRepository.findAll();
        for (Shampoo shampoo : shampoos) {
            shampoo.getIngredients().remove(ingredient);
            this.shampooRepository.save(shampoo);
        }

        ingredientRepository.save(ingredient);
        return this.ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public int increasePriceByPercentage(BigDecimal percent) {
        return this.ingredientRepository.increasePriceByPercent(percent);
    }

    @Override
    @Transactional
    public int updatePriceForGivenNames(List<String> ingredientNames) {
        return this.ingredientRepository.updatePriceForGivenNames(ingredientNames);
    }

    @Override
    public Ingredient findByName(String name) {
        return this.ingredientRepository.findByName(name);
    }

}
