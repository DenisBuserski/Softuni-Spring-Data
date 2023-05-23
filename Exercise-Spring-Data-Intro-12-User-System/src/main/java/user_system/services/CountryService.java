package user_system.services;

import user_system.entities.Country;

public interface CountryService {
    void createCountry(String name);

    Country getCountryByName(String name);
}
