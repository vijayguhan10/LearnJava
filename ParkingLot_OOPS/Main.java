package ParkingLot_OOPS;
import java.util.ArrayList;
import java.util.List;

// ---------------- Vehicle ----------------
class Vehicle {
    private String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

// ---------------- Parking Spot ----------------
class ParkingSpot {
    private int id;
    private boolean free = true;

    public ParkingSpot(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return free;
    }

    public void occupy() {
        free = false;
    }

    public void release() {
        free = true;
    }

    public int getId() {
        return id;
    }
}

// ---------------- Ticket ----------------
class Ticket {
    private int spotId;
    private long entryTime;

    public Ticket(int spotId) {
        this.spotId = spotId;
        this.entryTime = System.currentTimeMillis();
    }

    public int getSpotId() {
        return spotId;
    }

    public long getEntryTime() {
        return entryTime;
    }
}

// ---------------- Payment Interface ----------------
interface Payment {
    void pay(double amount);
}

// ---------------- Payment Implementations ----------------
class CashPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using CASH");
    }
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using CARD");
    }
}

class GPayPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using GPAY");
    }
}

// ---------------- Parking Lot ----------------
class ParkingLot {

    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLot(int totalSpots) {
        for (int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    public Ticket park(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isFree()) {
                spot.occupy();
                System.out.println(
                        "Vehicle " + vehicle.getNumber()
                        + " parked at spot " + spot.getId());
                return new Ticket(spot.getId());
            }
        }
        throw new RuntimeException("No parking space available");
    }

    public void exit(Ticket ticket, Payment payment) {
        ParkingSpot spot = spots.get(ticket.getSpotId() - 1);
        spot.release();

        long duration =
                (System.currentTimeMillis() - ticket.getEntryTime()) / 1000;
        double amount = duration * 10; // ₹10 per second

        payment.pay(amount);

        System.out.println("Vehicle exited from spot " + spot.getId());
    }
}

// ---------------- Main ----------------
public class Main {
    public static void main(String[] args) throws InterruptedException {

        ParkingLot parkingLot = new ParkingLot(2);

        Vehicle car = new Vehicle("KA-01-1234");

        Ticket ticket = parkingLot.park(car);

        Thread.sleep(3000); // parked for some time

        Payment payment = new GPayPayment();
        parkingLot.exit(ticket, payment);
    }
}
