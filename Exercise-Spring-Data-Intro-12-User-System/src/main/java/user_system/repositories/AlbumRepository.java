package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user_system.entities.Album;
import user_system.entities.Country;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album getAlbumById(int id);
}
