class Elevator {
    private static boolean ElevatorStatus;

    public void Setstatus() {
        this.ElevatorStatus = true;
    }

    public void RevertStatus() {
        this.ElevatorStatus = false;
    }

    public boolean getstatus() {
        return this.ElevatorStatus;
    }
}


interface ElevatorMovement {
    public void Movement();
}


interface ElevatorReached {
    public void ChangeState(Elevator E);
}


class Upstair implements ElevatorMovement {
    public void Movement() {
        System.err.println("The elevator is in the status of Moving");
    }
}


class Downstair implements ElevatorMovement {
    public void Movement() {
        System.err.println("The elevator is in the status of Down comming");
    }
}


class Reached implements ElevatorReached {
    public void ChangeState(Elevator E) {
        E.RevertStatus();
    }
}


public class ElevatorApplication {
    public static void main(String[] args) throws InterruptedException {
        Elevator e = new Elevator();
        e.Setstatus();
        Thread.sleep(3000); 
        Downstair d = new Downstair();
        d.Movement();
        Reached r = new Reached();
        r.ChangeState(e);
    }
}
