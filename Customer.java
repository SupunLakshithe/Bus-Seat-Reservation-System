import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String email , name , city , phnumber;
    int age;
    //private List<Reservation> reservations;

    public String phnumber() {
        return phnumber;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public Customer(String email , String name , String city , int age , String phnumber) {

        this.name = name;
        this.city = city;
        this.email = email;
        this.phnumber = phnumber;
        this.age = age;
        //this.reservations = new ArrayList<>();

    }

/*    public List<Reservation> getReservations(){
        //Return all the reservations
        return new ArrayList<>(reservations);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(String busNumber, int seatNumber) {
        reservations.removeIf(reservation ->
                reservation.busNumber().equals(busNumber) && reservation.seatNumber() == seatNumber);
    }*/
}
