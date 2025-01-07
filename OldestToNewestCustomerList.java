import java.util.LinkedList;
import java.util.List;

public class OldestToNewestCustomerList {
    private List<Customer> customerList = new LinkedList<>();

    // Add a new customer to the end of the list (oldest-first order)
    public void addCustomer(Customer customer) {
        customerList.add(0, customer);
    }

    // Get the newest customer (most recently added)
    public Customer getNewestCustomer() {
        if (customerList.isEmpty()) {
            return null; // Return null if the list is empty
        }
        return customerList.get(customerList.size() - 1);
    }

    // Get the oldest customer (first added)
    public Customer getOldestCustomer() {
        if (customerList.isEmpty()) {
            return null; // Return null if the list is empty
        }
        return customerList.get(0);
    }

    // Get all customers in reverse order (from newest to oldest)
    public List<Customer> getAllCustomersInReverseOrder() {
        List<Customer> reversedList = new LinkedList<>(customerList);
        return reversedList;
    }
}
