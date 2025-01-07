import java.util.*;

public class BSRS {

    private Map<String, Customer> customers;
    private List<Bus> buses;
    private Map<String, List<Boolean>> seatAvailability;
    private List<Reservation> reservations;
    private Map<String,Queue<Customer>> seatRequestQueue;

    private Date time;

    public BSRS() {
        customers = new HashMap<>();
        buses = new ArrayList<>();
        seatAvailability = new HashMap<>();
        reservations = new ArrayList<>();
        seatRequestQueue = new HashMap<>();

        //loadData();

    }

    //Customer Registration ------------------------------------------------------------------------------------------------
    public boolean addCustomer(Customer customer) {

        //check if customer already exist
        if (customerExists(customer.email())) {
            System.out.println("Customer with email " + customer.email() + " is Already Exists. Fail");
            return false;
        }

        //adding customer to the map
        customers.put(customer.email(), customer);
        System.out.println("Customer with email: " + customer.email() + " added. Successfully");
        return true;
    }

    public Customer getCustomer(String email) {
        //check customer exists
        if (customerExists(email)) {
            return customers.get(email);
        } else
            System.out.println("Customer does not Exists. Fail");
        return null;
    }

    public boolean updateCustomer(String email, Customer updateCustomer) {
        //check if exists
        if (customerExists(email)) {
            customers.put(email, updateCustomer);
            System.out.println("Customer data updated. Successfully");
            return true;
        } else {
            System.out.println("Customer does not exists,. Fail");
            return false;
        }
    }

    public void removeCustomer(String email) {
        //check if exists
        if (customerExists(email)) {
            removeCustomerFromAllSeatRequestQueues(customers.get(email));
            customers.remove(email);
            System.out.println("Customer with email " + email + " is removed. Successful");
        } else {
            System.out.println("Customer deos not exist. Fail");
        }
    }

    public String customersToString() {
        //return all the customers
        return "BSRS{" +
                "customers=" + customers +
                '}';
    }

    public List<Customer> customerAll() {
        return new ArrayList<>(customers.values());
    }

    public int customerCount() {
        return customers.size();
    }

    public boolean customerExists(String email) {
        //check if customer exist on map
        if (customers.containsKey(email)) {
            return true;
        } else {
            return false;
        }
    }

//buses registration----------------------------------------------------------------------------------------------------

    public void addBus(Bus bus) {

        //adding a bus
        buses.add(bus);
        System.out.println("Bus with number " + bus.BNumber() + " is registered. Successful");

        //seat availability setup
        seatAvailability.put(bus.BNumber(), new ArrayList<>(Collections.nCopies(bus.Total_seats(), true)));
    }

    public Bus getBus(String busNumber) {
        for (Bus bus : buses) {
            if (bus.BNumber().equals(busNumber)) {
                return bus;
            }
        }
        System.out.println("Bus with number " + busNumber + "does not exist. Fail");
        return null;
    }

    public void updateBus(String busNumber, Bus newBus) {
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.BNumber().equals(busNumber)) {
                buses.set(i, newBus);
                System.out.println("Bus with number " + busNumber + " updated. Successful");
                return;
            }
        }
        System.out.println("Bus with Number " + busNumber + " does not exists. Fail");
    }

    public boolean removeBus(String busNumber) {
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.BNumber().equals(busNumber)) {
                buses.remove(i);
                seatAvailability.remove(busNumber);
                System.out.println("Bus with number " + busNumber + " removed. Successful");
                return true;
            }
        }
        System.out.println("Bus with number " + busNumber + "does not exist. Fail");
        return false;
    }

    public List<Bus> busAll() {
        return new ArrayList<>(buses);
    }


    public boolean busExists(String busNumber) {
        for (Bus bus : buses) {
            if (bus.BNumber().equals(busNumber)) {
                return true;
            }
        }
        return false;
    }


//seat availability-----------------------------------------------------------------------------------------------------

    public boolean isSeatAvailable(String bNumber,int seatNumber){
        if (seatAvailability.containsKey(bNumber)){
            List<Boolean> seatStatus = seatAvailability.get(bNumber);
            if (seatNumber > 0 && seatNumber <= seatStatus.size()){
                return seatStatus.get(seatNumber-1);
            }
        }
        return false;
    }

   public boolean isSeatReservedByCustomer(String email, String bNumber, int seatNumber) {
       /* useless */
        if (customerExists(email)) {
            Customer customer = customers.get(email);
            for (Reservation reservation : reservations) {
                if (reservation.busNumber().equals(bNumber) && reservation.seatNumber()== seatNumber) {
                    return true; // The seat is reserved by the customer.
                }
            }
        }
        return false;
    }

    public void displaySeatAvailability(String busNumber) {
        if (seatAvailability.containsKey(busNumber)) {
            List<Boolean> seatStatus = seatAvailability.get(busNumber);
            System.out.println("Seat Availability for Bus " + busNumber + ":");
            for (int i = 0; i < seatStatus.size(); i++) {
                System.out.println("Seat " + (i + 1) + ": " + (seatStatus.get(i) ? "Available" : "Reserved"));
            }
        } else {
            System.out.println("Bus with number " + busNumber + " does not exist.");
        }
    }

//reservations----------------------------------------------------------------------------------------------------------
    public void reserveSeat(String bNumber, int seatNumber, Customer customer) {
        //check if bus available
        if (seatAvailability.containsKey(bNumber)) {
            //check if seat available
            List<Boolean> seatStatus = seatAvailability.get(bNumber);

            //check seat number
            if (seatNumber > 0 && seatNumber <= seatStatus.size()) {
                //check seat available
                if (seatStatus.get(seatNumber - 1)) {
                    seatStatus.set(seatNumber - 1, false); // Mark the seat as reserved.
                    // Update the customer's reservations.
                    reservations.add(new Reservation(customer.email(), seatNumber, bNumber, time));
                    // customer.addReservation(new Reservation(customer.email(),seatNumber,bNumber,time));
                    System.out.println("Seat " + seatNumber + " on bus " + bNumber + " reserved. Successful.");
                }else {
                    for (Reservation res: reservations) {
                        if (Objects.equals(res.seatNumber(),seatNumber) && Objects.equals(res.busNumber(), bNumber)){
                            System.out.println("Seat is already taken by "+res.CustomerMail() +". Fail");
                        }
                    }
                }
            }else{
                System.out.println("Seat number is does not valid. Fail");
            }
        }else{
            System.out.println("Seat " + seatNumber + " on bus " + bNumber + " is not available or does not exist. Fail");
        }
    }

    public void cancelReservation(String busNumber, int seatNumber, Customer customer) {
        if (seatAvailability.containsKey(busNumber)) {
            List<Boolean> seatStatus = seatAvailability.get(busNumber);
            if (seatNumber > 0 && seatNumber <= seatStatus.size() && !seatStatus.get(seatNumber - 1)) {
                seatStatus.set(seatNumber - 1, true); // Mark the seat as available.
                // Remove the reservation from the customer's records.
                reservations.removeIf(res -> res.busNumber().equals(busNumber) && res.seatNumber() == seatNumber);
                System.out.println("Reservation for seat " + seatNumber + " on bus " + busNumber + " canceled. Successful.");
                return;
            }
        }
        System.out.println("Seat " + seatNumber + " on bus " + busNumber + " is not reserved or does not exist. Fail");
    }
    public List<Reservation> allReservations(){
        return new ArrayList<>(reservations);
    }

//queue-----------------------------------------------------------------------------------------------------------------

    public void addToQueue(String seatId,Customer customer){

        //Create list for seat if absent
        seatRequestQueue.putIfAbsent(seatId,new LinkedList<>());

        //put customer to the queue
        Queue<Customer> requestQueue = seatRequestQueue.get(seatId);
        requestQueue.add(customer);
        System.out.println("Customer added to seat "+seatId+" Queue. Successful");

    }

    public Customer removeFromQueue(String seatID){
        if (seatRequestQueue.containsKey(seatID)){
            Queue<Customer> requestQueue = seatRequestQueue.get(seatID);
            if (!requestQueue.isEmpty()){
                return requestQueue.peek();
            }else {
                System.out.println("Seat Queu is Empty. Fail");
                return null;
            }
        }
        System.out.println("Seat does not have a Queue!");
        return null;
    }

    public void seatRequestQueue(String seatIdentifier) {
        Queue<Customer> requestQueue = seatRequestQueue.get(seatIdentifier);
        if (requestQueue != null) {
            System.out.println("Seat Request Queue for Seat " + seatIdentifier + ":");
            for (Customer customer : requestQueue) {
                System.out.println("Customer: " + customer.email());
            }
        } else {
            System.out.println("No requests in the queue for seat " + seatIdentifier+". Fail");
        }
    }

    public void removeCustomerFromAllSeatRequestQueues(Customer customer) {
        for (Queue<Customer> requestQueue : seatRequestQueue.values()) {
            requestQueue.remove(customer);
        }
        System.out.println("Customer " + customer.email() + " removed from all seat request queues.");
    }

    public Map<String, List<Customer>> getAllSeatRequestQueueData() {
        Map<String, List<Customer>> queueData = new HashMap<>();

        for (Map.Entry<String, Queue<Customer>> entry : seatRequestQueue.entrySet()) {
            String seatIdentifier = entry.getKey();
            Queue<Customer> requestQueue = entry.getValue();

            List<Customer> customerList = new ArrayList<>(requestQueue);
            queueData.put(seatIdentifier, customerList);
        }

        return queueData;
    }

    public String getAllSeatRequestQueueDataAsString() {
        StringBuilder dataAsString = new StringBuilder();

        for (Map.Entry<String, Queue<Customer>> entry : seatRequestQueue.entrySet()) {
            String seatIdentifier = entry.getKey();
            Queue<Customer> requestQueue = entry.getValue();

            dataAsString.append("* Seat: ").append(seatIdentifier).append("\n");

            for (Customer customer : requestQueue) {
                dataAsString.append("  Customer: ").append(customer.email()).append("\n");
            }
        }

        return dataAsString.toString();
    }



}
