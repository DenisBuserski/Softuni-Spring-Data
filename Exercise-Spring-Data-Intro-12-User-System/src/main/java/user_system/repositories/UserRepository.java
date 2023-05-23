package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_system.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
