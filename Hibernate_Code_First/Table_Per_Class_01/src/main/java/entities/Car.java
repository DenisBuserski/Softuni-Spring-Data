package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    private int seats;

    public Car(String type, String model, BigDecimal price, String fuelType, int seats) {
        super(type, model, price, fuelType);
        this.seats = seats;
    }
}
