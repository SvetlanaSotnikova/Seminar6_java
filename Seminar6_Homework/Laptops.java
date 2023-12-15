package Seminar6_Homework;

import java.util.Objects;

public class Laptops {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptops(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void displayInfo() {
        System.out.println("Model: " + model +
                           ", RAM: " + ram +
                           "GB, Storage: " + storage +
                           "GB, OS: " + os +
                           ", Color: " + color);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Laptops laptops = (Laptops) o;
        return ram == laptops.ram &&
                storage == laptops.storage &&
                Objects.equals(model, laptops.model) &&
                Objects.equals(os, laptops.os) &&
                Objects.equals(color, laptops.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, ram, storage, os, color);
    }

}
