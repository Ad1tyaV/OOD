import Vehicles.Bike;
import Vehicles.Bus;
import Vehicles.Car;
import store.Store;
import utils.ParkingSlots;

public class ParkingManager{
    // Singleton Instance
    private final Store store;

    public ParkingManager(Store store) {
        this.store = store;
    }

    public void serialParking() {
        for(int cars = 0; cars<210; cars++) {
            if(cars%10==0) {
                ParkingSlots slots = store.getParkingSlots();
                System.out.println("Bike Slots="+slots.bikeSlots()+" Car Slots="+ slots.carSlots()+" Bus Slots="+slots.busSlots());
            }
            Car tmp = new Car();
            if(store.parkVehicle(tmp)) {
                System.out.println("Parked Car");
            } else {
                System.out.println("Slots unavailable for Car");
            }
        }

        for(int bikes = 0; bikes<20; bikes++) {
            if(bikes%10==0) {
                ParkingSlots slots = store.getParkingSlots();
                System.out.println("Bike Slots="+slots.bikeSlots()+" Car Slots="+ slots.carSlots()+" Bus Slots="+slots.busSlots());
            }
            Bike tmp = new Bike();
            if(store.parkVehicle(tmp)) {
                System.out.println("Parked bike");
            } else {
                System.out.println("Slots unavailable for Bike");
            }
        }

        for(int buses = 0; buses<20; buses++) {
            if(buses%10==0) {
                ParkingSlots slots = store.getParkingSlots();
                System.out.println("Bike Slots="+slots.bikeSlots()+" Car Slots="+ slots.carSlots()+" Bus Slots="+slots.busSlots());
            }
            Bus tmp = new Bus();
            if(store.parkVehicle(tmp)) {
                System.out.println("Bus Parked");
            } else {
                System.out.println("Slots unavailable for Bus");
            }
        }
    }

    public void simulateParking() {
    }
}
