package Practice_OOPS;

/* =======================
   DATA MODEL (SRP)
   ======================= */
class Rider {
    private final String riderId;
    private final int distance;
    private final double time;
    private final boolean peak;

    public Rider(String riderId, int distance, double time, boolean peak) {
        this.riderId = riderId;
        this.distance = distance;
        this.time = time;
        this.peak = peak;
    }

    public String getRiderId() {
        return riderId;
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
   ABSTRACTION (OCP, DIP)
   ======================= */
interface RideType {
    String getType();
    double calculateFare(Rider rider);
}

/* =======================
   IMPLEMENTATIONS (LSP)
   ======================= */
class MiniRide implements RideType {

    private static final int BASE_FARE = 200;
    private static final int PER_KM_RATE = 17;
    private static final int PER_MIN_RATE = 20;

    public String getType() {
        return "Mini";
    }

    public double calculateFare(Rider rider) {
        double fare = BASE_FARE +
                (rider.getDistance() * PER_KM_RATE) +
                (rider.getTime() * PER_MIN_RATE);

        if (rider.isPeak()) {
            fare += fare * 0.25;
        }
        return fare;
    }
}

class SedanRide implements RideType {

    private static final int BASE_FARE = 300;
    private static final int PER_KM_RATE = 20;
    private static final int PER_MIN_RATE = 25;

    public String getType() {
        return "Sedan";
    }

    public double calculateFare(Rider rider) {
        double fare = BASE_FARE +
                (rider.getDistance() * PER_KM_RATE) +
                (rider.getTime() * PER_MIN_RATE);

        if (rider.isPeak()) {
            fare += fare * 0.25;
        }
        return fare;
    }
}

class SuvRide implements RideType {

    private static final int BASE_FARE = 400;
    private static final int PER_KM_RATE = 25;
    private static final int PER_MIN_RATE = 30;

    public String getType() {
        return "SUV";
    }

    public double calculateFare(Rider rider) {
        double fare = BASE_FARE +
                (rider.getDistance() * PER_KM_RATE) +
                (rider.getTime() * PER_MIN_RATE);

        if (rider.isPeak()) {
            fare += fare * 0.25;
        }
        return fare;
    }
}

/* =======================
   INVOICE (IMMUTABLE)
   ======================= */
class Invoice {
    private final String riderId;
    private final String rideType;
    private final double totalFare;
    public Invoice(String riderId, String rideType, double totalFare) {
        this.riderId = riderId;
        this.rideType = rideType;
        this.totalFare = totalFare;
    }

    public void printInvoice() {
        System.out.println("----- Ride Invoice -----");
        System.out.println("Ride ID   : " + riderId);
        System.out.println("Ride Type : " + rideType);
        System.out.println("Total Fare: ₹" + totalFare);
    }
}

/* =======================
   SERVICE (DIP)
   ======================= */
class FareCalculator {

    public Invoice generateInvoice(Rider rider, RideType rideType) {
        double fare = rideType.calculateFare(rider);
        return new Invoice(rider.getRiderId(), rideType.getType(), fare);
    }
}

/* =======================
   ENTRY POINT
   ======================= */
public class Main {
    public static void main(String[] args) {

        Rider rider = new Rider("R101", 12, 20, true);

        RideType rideType = new SedanRide();   // MiniRide / SuvRide
        FareCalculator calculator = new FareCalculator();

        Invoice invoice = calculator.generateInvoice(rider, rideType);
        invoice.printInvoice();
    }
}    
