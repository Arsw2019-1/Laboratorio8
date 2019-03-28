package edu.eci.models;

import java.io.Serializable;

public class Car implements Serializable {

    private String licencePlate;
    private String brand;

    public Car() {
    }

    public Car(String licencePlate, String brand) {
        this.licencePlate = licencePlate;
        this.brand = brand;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
