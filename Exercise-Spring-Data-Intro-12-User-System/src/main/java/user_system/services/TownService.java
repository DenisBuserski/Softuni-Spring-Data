package user_system.services;

import user_system.entities.Country;
import user_system.entities.Town;

public interface TownService {
    void createTown(String name, Country country);

    Town getTownByName(String name);
}
