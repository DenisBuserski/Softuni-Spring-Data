package shampoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shampoo.entities.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    Label findById(int labelId);
}
