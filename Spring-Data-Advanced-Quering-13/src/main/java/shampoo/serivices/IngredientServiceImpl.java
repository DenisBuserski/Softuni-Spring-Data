package shampoo.serivices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shampoo.entities.Ingredient;
import shampoo.repositories.IngredientRepository;

import java.math.BigDecimal;
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

    @Override
    @Transactional
    public int deleteByName(String name) {
        return this.ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public int increasePriceByPercentage(BigDecimal percent) {
        return this.ingredientRepository.increasePriceByPercent(percent);
    }


}
