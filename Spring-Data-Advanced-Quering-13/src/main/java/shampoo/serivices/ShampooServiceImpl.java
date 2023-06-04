package shampoo.serivices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shampoo.entities.Label;
import shampoo.entities.Shampoo;
import shampoo.enums.Size;
import shampoo.repositories.LabelRepository;
import shampoo.repositories.ShampooRepository;

import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, LabelRepository labelRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
    }

    @Override
    public List<Shampoo> findBySizeOrderById(Size size) {
        return this.shampooRepository.findBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, int labelId) {
        // Label label = this.labelRepository.findById(labelId);
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }
}
