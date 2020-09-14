package ru.job4j.design.lsp;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.design.parking.*;

import java.io.IOException;

public class ParkingTest {

    @Test
    public void whenAddCar() throws IOException {
        ParkingInterface parking = new Parking();
        VehicleInterface car = new Car("AA777A777", "BMW X7");
        Assert.assertTrue(parking.add(car));
    }

    @Test
    public void whenAddCarThenGetMachine() throws IOException {
        ParkingInterface parking = new Parking();
        VehicleInterface car = new Car("AA777A777", "BMW X7");
        Assert.assertTrue(parking.add(car));
        Assert.assertEquals(car, parking.getMachine(car.number()));
    }

    @Test
    public void whenAddBusThenGetMachine() throws IOException {
        ParkingInterface parking = new Parking();
        VehicleInterface bus = new Bus("AA777A777", "BMW X7", 2);
        Assert.assertTrue(parking.add(bus));
        Assert.assertEquals(bus, parking.getMachine(bus.number()));
    }

    @Test
    public void whenAddBusToCarParking() throws IOException {
        ParkingInterface parking = new Parking();
        VehicleInterface bus = new Bus("AA777A777", "BMW X7", 2);
        VehicleInterface bus2 = new Bus("AA777A177", "BMW X7", 99);
        Assert.assertTrue(parking.add(bus));
        Assert.assertTrue(parking.add(bus2));
        Assert.assertEquals(bus2, parking.getMachine(bus2.number()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddBusThenNoPlaces() throws IOException {
        ParkingInterface parking = new Parking();
        VehicleInterface bus = new Bus("AA777A777", "BMW X7", 2);
        VehicleInterface bus2 = new Bus("AA777A177", "BMW X7", 99);
        VehicleInterface bus3 = new Bus("AA777A77", "BMW X7", 9);
        parking.add(bus);
        parking.add(bus2);
        Assert.assertFalse(parking.add(bus3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddCarThenNoPlaces() throws IOException {
        ParkingInterface parking = new Parking();
        VehicleInterface bus = new Bus("AA777A777", "BMW X7", 2);
        VehicleInterface bus2 = new Bus("AA777A177", "BMW X7", 99);
        VehicleInterface car = new Car("AA777A77", "BMW X7");
        VehicleInterface car1 = new Car("AA666A77", "BMW X7");
        parking.add(bus);
        parking.add(bus2);
        Assert.assertTrue(parking.add(car));
        Assert.assertFalse(parking.add(car1));
    }

}
