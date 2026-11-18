package org.example.parkingLot.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String parkingSpot;
    private String licensePlate;

    public String getParkingSpot() { return parkingSpot; }
    public void setParkingSpot(String parkingSpot) { this.parkingSpot = parkingSpot; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}