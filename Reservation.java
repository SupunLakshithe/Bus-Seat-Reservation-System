import java.util.Date;

public class Reservation {

    private int  seatNumber;
    private String busNumber , CustomerMail;
    private Date reservationTime;

    public String busNumber() {
        return busNumber;
    }

    public int seatNumber() {
        return seatNumber;
    }

    public String CustomerMail() {
        return CustomerMail;
    }

    public Reservation(String customerMail, int seatNumber, String busNumber, Date reservationTime) {
        CustomerMail = customerMail;
        this.seatNumber = seatNumber;
        this.busNumber = busNumber;
        this.reservationTime = reservationTime;
    }

    public String toString(){
        return "CustermerMail is " + CustomerMail + "\nBusNumber is " + busNumber + "\nSeatNumber is" +seatNumber+ "\nReservationTime is " +reservationTime;
    }
}
