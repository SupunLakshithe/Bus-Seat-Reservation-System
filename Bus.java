public class Bus {

    private String BNumber , Starting_point , End_point , Start_time;
    private int Fare , Total_seats;

    public Bus(String BNumber, String starting_point, String end_point, String start_time, int fare, int total_seats) {
        this.BNumber = BNumber;
        Starting_point = starting_point;
        End_point = end_point;
        Start_time = start_time;
        Fare = fare;
        Total_seats = total_seats;
    }

    public String toString(){
        return "BusNumber is " + BNumber + "\nStarting point is " + Starting_point + "\nEnd point is " + End_point + "\nStart time is " +Start_time + "\nTotal seats are " + Total_seats;
    }

    public String BNumber() {
        return BNumber;
    }

    public String Starting_point() {
        return Starting_point;
    }

    public String End_point() {
        return End_point;
    }

    public String Start_time() {
        return Start_time;
    }

    public int Fare() {
        return Fare;
    }

    public int Total_seats() {
        return Total_seats;
    }
}
