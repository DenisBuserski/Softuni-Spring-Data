package exercise.services;

import exercise.entities.Shampoo;
import exercise.entities.Size;
import exercise.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;


@Service
public class ShampooServiceImpl implements ShampooService {

    @Autowired
    private ShampooRepository shampooRepository;


    @Override
    public List<Shampoo> selectBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override
    public List<Shampoo> selectBySizeORLabelId(Size size, int labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countByPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> selectByIngredientCount(int count) {
        return this.shampooRepository.findByIngredientCountLessThan(count);
    }

    @Override
    public List<String> findByIngredientsNames(List<String> names) {
        return this.shampooRepository.findByIngredients(names);
    }
}
