package shampoo.serivices;

import shampoo.entities.Shampoo;
import shampoo.enums.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findBySizeOrderById(Size size);
}
