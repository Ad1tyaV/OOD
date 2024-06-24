import Vehicles.Vehicle;
import store.Store;
import utils.ParkingSlots;

public class VehicleThread implements Runnable{
    public static Store store;
    Class<? extends Vehicle> vehicle;

    public VehicleThread(Class<? extends Vehicle> vehicle) {
        store = Store.getInstance();
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        for(int vehicleNumber = 0; vehicleNumber<200; vehicleNumber++) {

            ParkingSlots parkingSlots = store.getParkingSlots();
            System.out.println("Car slots = "+parkingSlots.carSlots()+ " Bike Slots="+parkingSlots.bikeSlots()+" Bus slots="+parkingSlots.busSlots());

            try {
                Vehicle instance = vehicle.getDeclaredConstructor().newInstance();
                if(!store.parkVehicle(instance)) {
                    System.out.println("Couldn't park "+ instance.getClass());
                } else {
                    System.out.println("Parked - "+ instance.getClass());
                }
            } catch(Exception exception) {
                exception.printStackTrace();
            }

            // Simulate waiting
            try {
                Thread.sleep((int) (Math.random() * 143));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
