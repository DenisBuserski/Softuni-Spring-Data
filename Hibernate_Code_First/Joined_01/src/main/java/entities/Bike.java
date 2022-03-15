package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle {

    public Bike(String type, String model, BigDecimal price, String fuelType) {
        super(type, model, price, fuelType);
    }
}
