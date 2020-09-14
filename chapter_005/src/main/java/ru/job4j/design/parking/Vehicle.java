package ru.job4j.design.parking;

import java.util.Objects;

public abstract class Vehicle implements VehicleInterface {
    private String number;
    private String name;
    private int size;

    public Vehicle(String number, String name, int size) {
        this.number = number;
        this.name = name;
        this.size = size;
    }
    public Vehicle(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String number() {
        return this.number;
    }

    @Override
    public int sizePlace() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return size == vehicle.size &&
                Objects.equals(number, vehicle.number) &&
                Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, size);
    }
}
