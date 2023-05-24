package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import user_system.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int id);

    @Query(
            value = "SELECT concat(first_name, ' ', last_name) FROM users where id = ?1",
            nativeQuery = true)
    String getFirstAndLastNameById(int id);
}
