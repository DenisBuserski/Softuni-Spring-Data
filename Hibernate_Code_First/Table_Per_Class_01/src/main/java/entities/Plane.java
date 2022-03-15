package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle {

    @Column(name = "passenger_capacity")
    private int passengerCapacity;
    private String airline;

    public Plane(String type, String model, BigDecimal price, String fuelType, String airline, int passengerCapacity) {
        super(type, model, price, fuelType);
        this.airline = airline;
        this.passengerCapacity = passengerCapacity;
    }
}
