package ru.job4j.design.parking;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking implements ParkingInterface {
    private static final int CAR_PLACE = 100;
    private static final int BUS_PLACE = 10;
    private int carPlaces;
    private int busPlaces;
    private List<VehicleInterface> cars = new ArrayList<>();
    private List<VehicleInterface> bus = new ArrayList<>();

    public Parking() {
        this.carPlaces = CAR_PLACE;
        this.busPlaces = BUS_PLACE;
    }

    @Override
    public boolean add(VehicleInterface vehicle) throws IOException {
        if (vehicle == null) {
            throw new IOException();
        }
        if (!FreePlace(vehicle)) {
            throw new IllegalArgumentException();
        } else {
            if (vehicle.sizePlace() == 1 || ( vehicle.sizePlace() > 1 && vehicle.sizePlace() > busPlaces)) {
                cars.add(vehicle);
                carPlaces-= vehicle.sizePlace();
            } else {
                bus.add(vehicle);
                busPlaces-= vehicle.sizePlace();
            }
        }
        return  true;
    }

    @Override
    public VehicleInterface getMachine(String number) throws IOException {
        if (number == null) {
            throw new IOException();
        }
        List<VehicleInterface> resultCar = cars.stream().filter(t -> t.number().equals(number)).collect(Collectors.toList());
        if (resultCar.size() > 0) {
            carPlaces += resultCar.get(0).sizePlace();
            return resultCar.get(0);
        }
        List<VehicleInterface> resultBus = bus.stream().filter(t -> t.number().equals(number)).collect(Collectors.toList());
        if (resultBus.size() > 0) {
            busPlaces++;
            return resultBus.get(0);
        }
        return null;
    }

    @Override
    public boolean FreePlace(VehicleInterface vehicle) throws IOException {
        if (vehicle == null) {
            throw new IOException();
        }
        if (vehicle.sizePlace() > 1 && (carPlaces >= vehicle.sizePlace())) {
            return true;
        }
        if (vehicle.sizePlace() == 1 && carPlaces > 0) {
            return true;
        }
        return false;
    }

}
