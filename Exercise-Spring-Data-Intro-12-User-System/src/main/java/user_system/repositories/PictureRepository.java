package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_system.entities.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
