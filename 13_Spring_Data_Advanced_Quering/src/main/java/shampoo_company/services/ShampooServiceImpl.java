package shampoo_company.services;

import shampoo_company.entities.Shampoo;
import shampoo_company.entities.Size;
import shampoo_company.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;


@Service
public class ShampooServiceImpl implements ShampooService {

    @Autowired
    private ShampooRepository shampooRepository;

    @Override // 01
    public List<Shampoo> selectBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override // 02
    public List<Shampoo> selectBySizeORLabelId(Size size, int labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override // 03
    public List<Shampoo> selectMoreExpensiveThan(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override // 06
    public int countByPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override // 08
    public List<Shampoo> selectByIngredientCount(int count) {
        return this.shampooRepository.findByIngredientCountLessThan(count);
    }

    @Override // 07
    public List<String> findByIngredientsNames(List<String> names) {
        return this.shampooRepository.findByIngredients(names);
    }
}
