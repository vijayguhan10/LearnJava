package Vehicle;

class VehicleServe {
    private String vehicleNo;
    private String type;
    private int totalHours;
    private String ticket;
    private int amountPaid;

    public VehicleServe(String vehicleNo, String type) {
        this.vehicleNo = vehicleNo;
        this.type = type;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getType() {
        return type;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void displayDetails() {
        System.out.println("------ VEHICLE DETAILS ------");
        System.out.println("Vehicle Number : " + vehicleNo);
        System.out.println("Vehicle Type   : " + type);
        System.out.println("Total Hours    : " + totalHours);
        System.out.println("Ticket ID      : " + ticket);
        System.out.println("Amount Paid    : ₹" + amountPaid);
        System.out.println("-----------------------------");
    }
}

// PaymentMethod.java
interface PaymentMethod {
    void pay(VehicleServe vehicle, int amount);
}

// CreditCardPayment.java
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(VehicleServe vehicle, int amount) {
        vehicle.setAmountPaid(amount);
        System.out.println("Payment done using Credit Card");
    }
}

// UpiPayment.java
class UpiPayment implements PaymentMethod {
    @Override
    public void pay(VehicleServe vehicle, int amount) {
        vehicle.setAmountPaid(amount);
        System.out.println("Payment done using UPI");
    }
}

// ParkingFeeCalculator.java
class ParkingFeeCalculator {
    public int calculateFee(int hours) {
        return hours * 10;
    }
}

// TicketGeneratingService.java
class TicketGeneratingService {
    public String generateTicket(VehicleServe vehicle) {
        return vehicle.getVehicleNo() + "-" + vehicle.getType() + "-" + System.currentTimeMillis();
    }
}

// VehicleService.java
class VehicleService {
    private ParkingFeeCalculator calculator;
    private TicketGeneratingService ticketService;

    public VehicleService(ParkingFeeCalculator calculator, TicketGeneratingService ticketService) {
        this.calculator = calculator;
        this.ticketService = ticketService;
    }

    public void processVehicle(VehicleServe vehicle) {
        String ticket = ticketService.generateTicket(vehicle);
        vehicle.setTicket(ticket);

        int amount = calculator.calculateFee(vehicle.getTotalHours());
        vehicle.setAmountPaid(amount);
    }
}

// Main.java
public class Vehicle {
    public static void main(String[] args) {

        VehicleServe vehicle = new VehicleServe("TN01AB1234", "Car");
        vehicle.setTotalHours(5);
        ParkingFeeCalculator calculator = new ParkingFeeCalculator();
        TicketGeneratingService ticketService = new TicketGeneratingService();
        VehicleService vehicleService = new VehicleService(calculator, ticketService);
        vehicleService.processVehicle(vehicle);
        PaymentMethod payment = new UpiPayment(); 
        payment.pay(vehicle, vehicle.getAmountPaid());
        vehicle.displayDetails();
    }
}
