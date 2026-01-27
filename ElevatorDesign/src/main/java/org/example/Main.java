package org.example;

import Commodities.Building;
import ElevatorOperation.*;
import ElevatorStrategy.NearestElevatorStrategy;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ElevatorCar elevatorCar1 = new ElevatorCar(1);
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar(2);
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);

        InternalButton internalButton1 = new InternalButton(elevatorController1);
        InternalButton internalButton2 = new InternalButton(elevatorController2);

        ElevatorScheduler elevatorScheduler = new ElevatorScheduler(Arrays.asList(elevatorController1,elevatorController2), new NearestElevatorStrategy());
        ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorScheduler);

        Building building = new Building(5, externalDispatcher);
        new Thread(elevatorController1, "Elevator-1").start();
        new Thread(elevatorController2, "Elevator-2").start();

        // Simulating some requests
        /*
        1. External call: Floor 3 UP
        2. External call: Floor 5 DOWN
        3. Internal call: Elevator 1 (press 4)
        4. Internal call: Elevator 1 (press 5)
        5. External call: Floor 1 DOWN
        6. External call: Floor 2 UP
         */

        building.getFloor(3).pressUpButton();
        Thread.sleep(50);

        building.getFloor(5).pressDownButton();
        Thread.sleep(50);

        internalButton1.pressButton(4);
        Thread.sleep(50);

        internalButton1.pressButton(5);
        Thread.sleep(50);

        building.getFloor(1).pressDownButton();
        Thread.sleep(50);

        building.getFloor(2).pressUpButton();
        Thread.sleep(50);

        building.getFloor(3).pressUpButton();
        Thread.sleep(50);
    }
}