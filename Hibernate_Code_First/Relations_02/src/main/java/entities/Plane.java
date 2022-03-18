package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "planes")
public class Plane extends Vehicle {

    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Plane() {}
    public Plane(String type, String model, BigDecimal price, String fuelType, Integer passengerCapacity, Company company) {
        super(type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.company = company;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
