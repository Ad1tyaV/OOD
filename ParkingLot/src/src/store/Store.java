package store;

import Vehicles.Bike;
import Vehicles.Bus;
import Vehicles.Car;
import Vehicles.Vehicle;
import utils.ParkingSlots;

public class Store {
    private static Store store;
    private int BIKE_SLOTS;
    private int CAR_SLOTS;
    private int BUS_SLOTS;

    public static Store getInstance() {
        if(store==null) {
            store = new Store();
        }
        return store;
    }

    private Store() {
        BIKE_SLOTS = 25;
        CAR_SLOTS = 200;
        BUS_SLOTS = 20;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if(vehicle instanceof Car && CAR_SLOTS>0) {
            CAR_SLOTS--;
        } else if(vehicle instanceof Bus && BUS_SLOTS>0) {
            BUS_SLOTS--;
        } else if(BIKE_SLOTS>0){
            BIKE_SLOTS--;
        } else {
            return false;
        }
        return true;
    }

    public synchronized void exitParking(Vehicle vehicle) {
        if(vehicle instanceof Car) {
            CAR_SLOTS++;
        } else if(vehicle instanceof Bike) {
            BIKE_SLOTS++;
        } else {
            BUS_SLOTS++;
        }
    }

    public synchronized ParkingSlots getParkingSlots() {
        return new ParkingSlots(
                this.BIKE_SLOTS,
                this.CAR_SLOTS,
                this.BUS_SLOTS
        );
    }
}
