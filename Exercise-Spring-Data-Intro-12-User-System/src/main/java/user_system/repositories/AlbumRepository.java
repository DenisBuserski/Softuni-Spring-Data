package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user_system.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
