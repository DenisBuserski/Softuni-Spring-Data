package shampoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shampoo.entities.Label;
import shampoo.entities.Shampoo;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    Label findById(int labelId);
}
