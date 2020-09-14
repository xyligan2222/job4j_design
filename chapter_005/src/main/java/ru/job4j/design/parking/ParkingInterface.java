package ru.job4j.design.parking;

import java.io.IOException;

public interface ParkingInterface {
    boolean add(VehicleInterface vehicle) throws IOException;
    VehicleInterface getMachine(String number) throws IOException;
    boolean FreePlace(VehicleInterface vehicle) throws IOException;
}
