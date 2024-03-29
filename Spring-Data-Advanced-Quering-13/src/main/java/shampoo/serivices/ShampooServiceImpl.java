package shampoo.serivices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shampoo.entities.Shampoo;
import shampoo.enums.Size;
import shampoo.repositories.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findBySizeOrderById(Size size) {
        return this.shampooRepository.findBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, int labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findByIngredientsIn(List<String> names) {
        return this.shampooRepository.findShampooByIngredientsIn(names);
    }

    @Override
    public List<Shampoo> selectByIngredientsCount(int count) {
        return this.shampooRepository.findByIngredientCountLessThan(count);
    }

    @Override
    public List<String> findByIngredientsNames(List<String> ingredientNames) {
        return this.shampooRepository.findByIngredientsNames(ingredientNames);
    }
}
