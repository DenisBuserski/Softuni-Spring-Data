package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "countries")
public class Country  {

    @Id
    @Column(length = 3)
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "countries_continents",
            joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id")
    )
    private Set<Continent> continents;

    @OneToMany(targetEntity = Town.class, mappedBy = "country")
    private Set<Town> towns;

    public Country() {}
}
