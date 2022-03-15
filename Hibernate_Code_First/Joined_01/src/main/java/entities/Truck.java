package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {

    @Column(name = "load_capacity")
    private double loadCapacity;

    public Truck(String type, String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(type, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }
}
