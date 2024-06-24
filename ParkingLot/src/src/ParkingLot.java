import Vehicles.Bike;
import Vehicles.Bus;
import Vehicles.Car;
import store.Store;

public class ParkingLot {
    public static void main(String[] arh) {
        // Store store = Store.getInstance();
        // ParkingManager manager = new ParkingManager(store);
        // manager.simulateParking();
        threadedParking();
    }

    static void threadedParking() {
        Thread carThread = new Thread(new VehicleThread(Car.class));
        Thread bikeThread = new Thread(new VehicleThread(Bike.class));
        Thread busThread = new Thread(new VehicleThread(Bus.class));

        carThread.start();
        bikeThread.start();
        busThread.start();

        try {
            carThread.join();
            bikeThread.join();
            busThread.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
