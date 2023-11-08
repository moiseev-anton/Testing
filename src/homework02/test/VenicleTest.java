package homework02.test;

import homework02.main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class VenicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUpCar() {
        car = new Car("Toyota", "Corolla", 2010);
    }

    @BeforeEach
    void setUpMotorcycle() {
        motorcycle = new Motorcycle("Honda", "RXT3000", 2015);
    }

    @Test
    void testCarIsVenicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testCarNumWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void testMotorcycleNumWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void testCarTestDriveSpeed(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void testMotorcycleTestDriveSpeed(){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void testCarParkSpeed(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void testMotorcyclePaskSpeed(){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
