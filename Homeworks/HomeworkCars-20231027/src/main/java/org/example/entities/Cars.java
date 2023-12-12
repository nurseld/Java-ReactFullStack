package org.example.entities;

public class Cars {
    private int id;
    private String brand;
    private String model;
    private String bodyType;
    private int year;
    private String fuelType;
    private String gearType;
    private int enginePower;
    private double engineCapacity;
    private String color;

    public Cars() {
    }

    public Cars(int id, String brand, String model, String bodyType, int year, String fuelType, String gearType, int enginePower, double engineCapacity, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.year = year;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.enginePower = enginePower;
        this.engineCapacity = engineCapacity;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.model = bodyType;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
