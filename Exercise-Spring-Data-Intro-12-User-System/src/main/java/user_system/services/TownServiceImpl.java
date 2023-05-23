package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.entities.Country;
import user_system.entities.Town;
import user_system.repositories.TownRepository;

@Service
public class TownServiceImpl implements TownService {
    @Autowired
    private TownRepository townRepository;

    @Override
    public void createTown(String name, Country country) {
        Town town = new Town(name, country);
        this.townRepository.save(town);
    }
}
