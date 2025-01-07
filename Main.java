import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        Bus bus1 = new Bus("KU01", "KUR", "KANDY", "08:00", 100, 52);
        System.out.println(bus1.toString());

        Reservation res1 = new Reservation("1@dr",12,"KU12",null);
        System.out.println(res1.toString());

        Customer cus1 = new Customer("eerer","ereree","eere",12,"2332434");
        Customer cus2 = new Customer("rt","rtrtr","rtrt",13,"366567");

        BSRS default1 = new BSRS();
        default1.addCustomer(cus1);
        default1.addCustomer(cus2);

        //get customers
        List<Customer> customerList = default1.customerAll();
        for (Customer cus: customerList) {
            System.out.print("Customer mail = " +cus.email());
            System.out.print("\t name = " +cus.name() +"\n");

        }*/
        BSRS bsrs = new BSRS();

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Bus Seat Reservation System - BSRS");
            System.out.println("Please select an option:");
            System.out.println(
                    "(1) Manage Customers\n" +
                            "(2) Manage Buses\n" +
                            "(3) Manage Reservations");

            boolean check = true;
            while (check) {

                System.out.print("Enter input (1/2/3):");
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "1":
                        manageCustomers(bsrs);
                        check = false;
                        break;
                    case "2":
                        manageBuses(bsrs);
                        check = false;
                        break;
                    case "3":
                        reservations(bsrs);
                        check = false;
                        break;
                    default:
                        System.err.println("Input not valid. fail");
                }
            }
        }while (true);

    }

    public static void manageCustomers(BSRS bsrs){
        boolean Continue = true;
        while(Continue) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter 0 to Add new Customer or Enter customer email to Delete or Update\n" +
                    "Customers : \n");

            List<Customer> customerList = bsrs.customerAll();
            int turn = 1;
            int all = bsrs.customerCount();
            String UserInput;
            for (Customer cus : customerList) {
                System.out.print("mail = " + cus.email());
                System.out.print("\t (name = " + cus.name() + ")\n");
                turn++;
                if (all / 4 == turn) {
                    System.out.println("\t");
                    turn = 1;
                }
            }

            System.out.print("\nEnter input(email or 0):");
            UserInput = scanner.nextLine();

            switch (UserInput) {
                case "0" -> addCustomer(bsrs);
                case "99" -> Continue = false;
                default -> setCustomer(bsrs, UserInput);
            }
        }
    }

    public static void addCustomer(BSRS bsrs){
        Scanner scanner = new Scanner(System.in);
        String email,city,name,phnumber;
        int age;
        System.out.println("Enter Customer Details - ");
        System.out.print("\tEmail :");
        email = scanner.nextLine();
        if (!email.contains("@")) {
            System.err.println("Not Valid Email\n");
            return;
        }
        System.out.print("\tName :");
        name = scanner.nextLine();
        System.out.print("\tCity :");
        city = scanner.nextLine();
        System.out.print("\tPhone Number :");
        phnumber = scanner.nextLine();
        System.out.print("\tAge :");
        try {
            age = scanner.nextInt();
        }catch (Exception exception){System.err.println("only integers are support");return;}
        scanner.nextLine();
        Customer customer = new Customer(email,name,city,age,phnumber);
        bsrs.addCustomer(customer);
    }

    public static void setCustomer(BSRS bsrs , String mail){

        while (bsrs.customerExists(mail)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select an option\n" +
                    "[0] Delete Customer\n" +
                    "[1] Update Customer\n");
            System.out.print("Enter input(0 or 1) :");
            String input = scanner.nextLine();

            switch (input) {
                case "0" -> {
                    System.out.println("Are you sure?(yes)");
                    String res = scanner.nextLine();
                    if (Objects.equals(res, "yes") || Objects.equals(res, "YES")) {
                        bsrs.removeCustomer(mail);
                    }
                    return;
                }
                case "1" -> {
                    System.out.println("Update Customer data >" + mail);
                    System.out.print("\tName :");
                    String name = scanner.nextLine();
                    System.out.print("\tCity :");
                    String city = scanner.nextLine();
                    System.out.print("\tPhone Number :");
                    String phnumber = scanner.nextLine();
                    System.out.print("\tAge :");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = new Customer(mail, name, city, age, phnumber);
                    bsrs.updateCustomer(mail, customer);
                    return;
                }
                default -> {
                    return;
                }
            }
        }
        System.err.println("Input not valid");

    }
    public static void manageBuses(BSRS bsrs){
        boolean Continu = true;
        while(Continu) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter 0 to Add new Bus or Enter bus Number to Delete\n" +
                    "Buses : \n");
            int turn =1;
            List<Bus> busList = bsrs.busAll();
            String UserInput;
            for (Bus bus : busList) {
                System.out.print("Bus_Number = " + bus.BNumber() + "\n");
/*                turn++;
                if (all / 4 == turn) {
                    System.out.println("\t");
                    turn = 1;
                }*/
            }

            System.out.print("\nEnter input(Bus number or 0):");
            UserInput = scanner.nextLine();

            switch (UserInput) {
                case "0" -> addBus(bsrs);
                case "99" -> Continu = false;
                default -> deleteBus(bsrs, UserInput);
            }
        }
    }
    public static void addBus(BSRS bsrs){
        Scanner scanner = new Scanner(System.in);
        String BNumber , Starting_point , End_point , Start_time;
        int Fare , Total_seats;
        System.out.println("Enter Bus Details - ");
        System.out.print("\tBus Number :");
        BNumber = scanner.nextLine();
        System.out.print("\tStarting point :");
        Starting_point = scanner.nextLine();
        System.out.print("\tEnd point :");
        End_point = scanner.nextLine();
        System.out.print("\tStart time (00:00):");
        Start_time = scanner.nextLine();
        System.out.print("\tFare :");
        Fare = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\tTotal seats count :");
        try{
        Total_seats = scanner.nextInt();
        }catch (Exception ex){
            System.err.println("Only numbers are allowed");
            return;
        }
        scanner.nextLine();
        Bus bus = new Bus(BNumber,Starting_point, End_point,Start_time,Fare,Total_seats );
        bsrs.addBus(bus);
    }

    public static void deleteBus(BSRS bsrs,String bNumber){
        while (bsrs.busExists(bNumber)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your going to delete " +bNumber+" from system");
            System.out.println("Are you sure?(yes)");
            String res = scanner.nextLine();
            if (Objects.equals(res, "yes") || Objects.equals(res, "YES")) {
                bsrs.removeBus(bNumber);
            }
            return;
        }

    }


    public static void reservations(BSRS bsrs){
        boolean Continue =  true;
        while(Continue){
            System.out.println("\n** Reservations **");
            System.out.println("Please Select an option \n" +
                    "(3)[0] Add a Reservation\n" +
                    "(3)[1] List Reservations\n" +
                    "(3)[2] Remove a Reservation");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter input (0 or 1) :");
            String input = scanner.nextLine();
            switch (input) {
                case "0" -> addReservations(bsrs);
                case "1" -> listReservations(bsrs);
                case "2" -> removeReservation(bsrs);
                case "99" -> Continue =false;
                default -> {
                    System.err.println("Input not valid. fail");
                }
            }
        }

    }

    public static void addReservations(BSRS bsrs){
        System.out.println("\nCustomers:");
        List<Customer> customerList = bsrs.customerAll();
        int turn =1;

        for (Customer cus : customerList) {
            System.out.print("mail = " + cus.email());
            System.out.print("\t (name = " + cus.name() + ")\n");
/*            turn++;
            if (all / 4 == turn) {
                System.out.println("\t");
                turn = 1;
            }*/
        }
        System.out.println("Enter Customer email to add reservation");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input:");
        String customer = scanner.nextLine();
        if (!bsrs.customerExists(customer)){
            System.err.println("Cant found"); return;}
        System.out.println("Buses :\n");
        List<Bus> busList = bsrs.busAll();
        for (Bus bus : busList) {
            System.out.print("Bus_Number = " + bus.BNumber() + "\t");
            System.out.print("*Start point = " + bus.Starting_point() + "\t");
            System.out.print("*End point = " + bus.End_point() + "\t");
            System.out.print("*Start time = " + bus.Start_time() + "\t");
            System.out.print("*Fair = " + bus.Fare() + "\t");
            System.out.print("*Seat Number = " + bus.Total_seats() + "\n");
        }
        System.out.print("\nEnter Bus Number To reserve a seat:");
        String busN = scanner.nextLine();
        if(!bsrs.busExists(busN)){
            System.err.println("Cant found"); return;}
        Bus bus = bsrs.getBus(busN);
        System.out.println(bus.Total_seats()+" Seats Available in this Bus");
        bsrs.displaySeatAvailability(busN);
        System.out.print("Enter Seat Number (1 to "+bus.Total_seats()+") :");
        String seat = scanner.nextLine();
        //check seat available

        if (bsrs.isSeatAvailable(busN,Integer.parseInt(seat))){
            bsrs.reserveSeat(busN,Integer.parseInt(seat),bsrs.getCustomer(customer));
            System.out.println(seat+ " in " + busN+ " bus is Reserved to the " + bsrs.getCustomer(customer).name());
            return;
        }else {
            String seatId = seat + "-" + busN;
            System.out.println("This Seat is reserved by an another customer!\nEnter yes to **Add to the queue**");
            String inp = scanner.nextLine();
            if (!(Objects.equals(inp, "YES") || Objects.equals(inp, "yes"))){return;}
            bsrs.addToQueue(seatId,bsrs.getCustomer(customer));
        }

    }

    public static void listReservations(BSRS bsrs){
        System.out.println("Reservations:");
        List<Reservation> reserv = bsrs.allReservations();
        for (Reservation reservation: reserv) {
            System.out.print("[Customer :" + reservation.CustomerMail());
            System.out.print("\tBus :" + reservation.busNumber());
            System.out.print("\tSeat :" + reservation.seatNumber() + " ]\n");
        }
        System.out.println("\nQueues:");
        System.out.println(bsrs.getAllSeatRequestQueueDataAsString()+"\n");
    }

    public static void removeReservation(BSRS bsrs ){
        System.out.println("Reservations:");
        List<Reservation> reserv = bsrs.allReservations();
        int id =0;
        for (Reservation reservation: reserv) {
            System.out.print("("+id+") [Customer :" + reservation.CustomerMail());
            System.out.print("\tBus :" + reservation.busNumber());
            System.out.print("\tSeat :" + reservation.seatNumber() + " ]\n");
            id++;
        }
        System.out.println("Enter customer email , bus number and seat number to remove reservations");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID :");
        String input = scanner.nextLine();
        Reservation res1;
        try{
            if (!(Integer.parseInt(input)<id)){
                System.out.println("Not Valid"); return;}
            res1 = reserv.get(Integer.parseInt(input));
        }catch (Exception ex){
            System.err.println("Not Valid Id");
            return;
        }
        String email = res1.CustomerMail();
        String bus = res1.busNumber();
        String seat = Integer.toString(res1.seatNumber());
        /*
        System.out.print("Enter email:");
        String email = scanner.nextLine();
        System.out.print("Enter Bus number:");
        String bus = scanner.nextLine();
        System.out.print("Enter Seat:");
        String seat = scanner.nextLine();
         */
        if (!(bsrs.isSeatReservedByCustomer(email,bus,Integer.parseInt(seat)))){
            System.err.println("Reservation not available. Fail");
            return;
        }
        bsrs.cancelReservation(bus,Integer.parseInt(seat),bsrs.getCustomer(email));
        System.out.println("Notification: "+bsrs.getCustomer(email).name()+"'s reservation is canceled successfully");

        //add customer from queue

        String seatId = seat+"-"+bus;
        Customer cus2 = bsrs.removeFromQueue(seatId);
        bsrs.reserveSeat(bus,Integer.parseInt(seat),cus2);
        System.out.println("Notification: "+cus2.name()+" is added to the seat "+seatId+" From Queue");


    }
}