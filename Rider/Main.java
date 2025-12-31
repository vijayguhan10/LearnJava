package Rider;

/* =======================
   DATA MODEL (SRP)
   ======================= */
class Ride {
    private final String rideId;
    private final int distance;
    private final double time;
    private final boolean peak;

    public Ride(String rideId, int distance, double time, boolean peak) {
        this.rideId = rideId;
        this.distance = distance;
        this.time = time;
        this.peak = peak;
    }

    public String getRideId() {
        return rideId;
    }

    public int getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public boolean isPeak() {
        return peak;
    }
}

/* =======================
   ABSTRACTION (Template Method)
   ======================= */
abstract class RideType {

    protected abstract double baseFare();
    protected abstract double perKmRate();
    protected abstract double perMinRate();
    protected abstract double minimumFare();
    protected abstract String type();

    public final double calculateFare(Ride ride) {
        double fare = baseFare()
                + (ride.getDistance() * perKmRate())
                + (ride.getTime() * perMinRate());

        if (fare < minimumFare()) {
            fare = minimumFare();
        }

        if (ride.isPeak()) {
            fare += fare * 0.25;
        }

        return fare;
    }

    public String getType() {
        return type();
    }
}

/* =======================
   IMPLEMENTATIONS (LSP)
   ======================= */
class MiniRide extends RideType {

    protected double baseFare() { return 200; }
    protected double perKmRate() { return 17; }
    protected double perMinRate() { return 20; }
    protected double minimumFare() { return 50; }
    protected String type() { return "Mini"; }
}

class SedanRide extends RideType {

    protected double baseFare() { return 300; }
    protected double perKmRate() { return 20; }
    protected double perMinRate() { return 25; }
    protected double minimumFare() { return 80; }
    protected String type() { return "Sedan"; }
}

class SuvRide extends RideType {

    protected double baseFare() { return 400; }
    protected double perKmRate() { return 25; }
    protected double perMinRate() { return 30; }
    protected double minimumFare() { return 100; }
    protected String type() { return "SUV"; }
}

/* =======================
   INVOICE (IMMUTABLE)
   ======================= */
final class Invoice {
    private final String rideId;
    private final String rideType;
    private final double totalFare;

    public Invoice(String rideId, String rideType, double totalFare) {
        this.rideId = rideId;
        this.rideType = rideType;
        this.totalFare = totalFare;
    }

    public void printInvoice() {
        System.out.println("----- Ride Invoice -----");
        System.out.println("Ride ID   : " + rideId);
        System.out.println("Ride Type : " + rideType);
        System.out.println("Total Fare: ₹" + totalFare);
    }
}

/* =======================
   SERVICE (VERY SIMPLE)
   ======================= */
class FareCalculator {

    public Invoice generateInvoice(Ride ride, RideType rideType) {
        return new Invoice(
                ride.getRideId(),
                rideType.getType(),
                rideType.calculateFare(ride)
        );
    }
}

/* =======================
   ENTRY POINT
   ======================= */
public class Main {
    public static void main(String[] args) {

        Ride ride = new Ride("R101", 12, 20, true);

        RideType rideType = new SedanRide(); // MiniRide / SuvRide
        FareCalculator calculator = new FareCalculator();

        Invoice invoice = calculator.generateInvoice(ride, rideType);
        invoice.printInvoice();
    }
}
