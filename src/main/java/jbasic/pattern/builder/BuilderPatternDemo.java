package jbasic.pattern.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Car car1 = new CarBuilder()
                .setBrand("Tesla")
                .setModel("Model S")
                .setYear(2023)
                .setEngine("Electric")
                .setSunroof(true)
                .build();

        System.out.println(car1);

        Car car2 = new CarBuilder()
                .setBrand("Ford")
                .setModel("Mustang")
                .setYear(2022)
                .setEngine("V8")
                .setSunroof(false)
                .build();

        System.out.println(car2);
    }
}