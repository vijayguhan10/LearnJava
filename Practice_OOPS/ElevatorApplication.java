package Practice_OOPS;

class Elevator {
    private boolean elevatorStatus;

    public void setStatus() {
        this.elevatorStatus = true;
    }

    public void revertStatus() {
        this.elevatorStatus = false;
    }

    public boolean isActive() {
        return this.elevatorStatus;
    }
}


interface ElevatorMovement {
    void movement();
}


interface ElevatorReached {
    void changeState(Elevator elevator);
}


class Upstair implements ElevatorMovement {
    public void movement() {
        System.out.println("The elevator is moving up");
    }
}


class Downstair implements ElevatorMovement {
    public void movement() {
        System.out.println("The elevator is coming down");
    }
}


class Reached implements ElevatorReached {
    public void changeState(Elevator elevator) {
        elevator.revertStatus();
    }
}


public class ElevatorApplication {
    public static void main(String[] args) throws InterruptedException {
        Elevator e = new Elevator();
        e.setStatus();
        Thread.sleep(3000);
        Downstair d = new Downstair();
        d.movement();
        Reached r = new Reached();
        r.changeState(e);
        System.out.println("Elevator active status: " + e.isActive());
    }
}
