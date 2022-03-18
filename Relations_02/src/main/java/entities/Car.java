package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    @Column(name = "seats")
    private Integer seats;

    @OneToOne(optional = false)
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    private PlateNumber plateNumber;

    public Car() {
    }
    public Car(String type, String model, BigDecimal price, String fuelType, Integer seats, PlateNumber plateNumber) {
        super(type, model, price, fuelType);
        this.seats = seats;
        this.plateNumber = plateNumber;
    }

    public Integer getSeats() {
        return seats;
    }
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    public PlateNumber getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
