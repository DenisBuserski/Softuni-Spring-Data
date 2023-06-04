package shampoo.serivices;

import shampoo.entities.Shampoo;
import shampoo.enums.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> selectBySizeOrLabelId(Size size, int labelId);

    List<Shampoo> selectMoreExpensiveThan(BigDecimal price);
}
