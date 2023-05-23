package user_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_system.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country getCountryByName(String name);

}
