package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_system.entities.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {
}
