package jbasic.pattern.builder;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final String engine;
    private final boolean sunroof;

    public Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
        this.engine = builder.engine;
        this.sunroof = builder.sunroof;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engine='" + engine + '\'' +
                ", sunroof=" + sunroof +
                '}';
    }

    // Getter methods (optional)
}
