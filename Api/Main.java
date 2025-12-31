
 package Api;

class User {
    private int userid;
    private String username;

    public User(int userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public String getusername() {
        return username;
    }
}


class Api {
    private int userid;
    private int requestCount;
    private final int ratelimit = 10;

    public Api(int id) {
        this.userid = id;
    }

    public void reset() {
        this.requestCount = 0;
    }

    public void hitrequest() {
        this.requestCount++;
    }

    public int getuserid() {
        return this.userid;
    }

    public int getrequestcount() {
        return this.requestCount;
    }



    public int getratelimit() {
        return this.ratelimit;
    }
}



class ApiServieces {
    private Api ap;
    private User us;

    public ApiServieces(Api ap, User us) {
        this.ap = ap;
        this.us = us;
    }

    public void ResetRequest() {
        ap.reset();
    }

    public void apihit() {
        ap.hitrequest();
    }

    public void displayDetails() {
        System.out.println("User Id :  " + ap.getuserid());
        System.out.println("User Name :  " + us.getusername());
        System.out.println("Total Request count :  " + ap.getrequestcount());
        System.out.println("Rate Limit:  " + ap.getratelimit());

    }
}


public class Main {
    public static void main(String[] args) {
        User us = new User(0, "vijay Guhan");
        User us2 = new User(0, "vishnu Ram");

        Api ap = new Api(0);
        Api ap1 = new Api(0);
        ApiServieces aps = new ApiServieces(ap, us);
        ApiServieces aps1 = new ApiServieces(ap1, us2);

        aps.apihit();
        aps.displayDetails();
        aps1.apihit();
        aps1.displayDetails();
    }
}
