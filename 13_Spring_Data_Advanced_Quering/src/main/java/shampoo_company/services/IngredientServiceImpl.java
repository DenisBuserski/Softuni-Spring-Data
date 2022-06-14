package shampoo_company.services;

import shampoo_company.entities.Ingredient;
import shampoo_company.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override /// 04
    public List<Ingredient> selectNameStartsWith(String letter) {
        return this.ingredientRepository.findByNameStartingWith(letter);
    }

    @Override // 05
    public List<Ingredient> selectInNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override // 09
    public int deleteByName(String name) {
        return this.ingredientRepository.deleteByName(name);
    }

    @Override // 10
    public void increasePriceByPercentage(double percent) {
        BigDecimal actualPercent = BigDecimal.valueOf(percent);
        this.ingredientRepository.increasePriceByPercent(actualPercent);
    }

    @Override // 11
    public void increasePriceOfIngredients(List<String> ingredients) {
        this.ingredientRepository.increasePriceOfIngredients(ingredients);
    }

}
