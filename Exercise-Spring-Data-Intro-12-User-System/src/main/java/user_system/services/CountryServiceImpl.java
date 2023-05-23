package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.entities.Country;
import user_system.repositories.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void createCountry(String name) {
        Country country = new Country(name);
        countryRepository.save(country);
    }

    @Override
    public Country getCountryByName(String name) {
        return this.countryRepository.getCountryByName(name);
    }
}
