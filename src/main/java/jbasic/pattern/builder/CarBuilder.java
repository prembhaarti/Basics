package jbasic.pattern.builder;

public class CarBuilder {
    String brand;
    String model;
    int year;
    String engine;
    boolean sunroof;

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this; // Enables method chaining
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    public Car build() {
        return new Car(this);
    }
}