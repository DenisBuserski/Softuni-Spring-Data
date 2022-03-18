package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {

    @Column(name = "load_capacity")
    private double loadCapacity;

    @ManyToMany()
    @JoinTable(name = "driver_trucks",
    joinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    private List<Driver> driver;

    public Truck(String type, String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(type, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
