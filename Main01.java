import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        // Create an instance of the OldestToNewestCustomerList
        OldestToNewestCustomerList customerList = new OldestToNewestCustomerList();

        // Add customers (oldest to newest)
        customerList.addCustomer(new Customer("John@g", "john","kur",32,"4334343"));
        customerList.addCustomer(new Customer("Alice@g", "alice","kur",22,"212132"));
        customerList.addCustomer(new Customer("Bob@g", "bob","kur",18,"000000"));
        customerList.addCustomer(new Customer("Carl@g", "carl","kr",18,"000000"));
        customerList.addCustomer(new Customer("Cassei@g", "cassie","kr",36,"000000"));

        System.out.println("Newest Customer is :- "+ customerList.getNewestCustomer().name());
        System.out.println("Oldest Customer is :- "+customerList.getOldestCustomer().name());
        // Retrieve all customers in reverse order
        System.out.println("Customers:");
        List<Customer> reversedCustomers = customerList.getAllCustomersInReverseOrder();
        for (Customer customer: reversedCustomers) {
            System.out.println("\t*\t"+customer.name());

        }
//----------------------- sorts---------------------------------------------------------------------------------------
        Customer[] customers = {
                new Customer("John@g", "john","kur",32,"4334343"),
                new Customer("Alice@g", "alice","kur",22,"212132"),
                new Customer("Bob@g", "bob","kur",18,"000000"),
                new Customer("Carl@g", "carl","kr",68,"000000"),
                new Customer("Cassei@g", "cassie","kr",36,"000000")

        };

        long time1 = System.currentTimeMillis();
        System.out.println("\nSorting Started at :- "+time1+"Milliseconds");
        CustomerSorter.quickSortByAge(customers, 0, customers.length - 1);

        System.out.println("\nSorted Customers by quickSortByAge:");
        for (Customer customer : customers) {
            System.out.println("\tName: " + customer.name() + ", Age: " + customer.age);
        }

        long time2 = System.currentTimeMillis();
        System.out.println("*** Time duration: "+(time2-time1)+" milliseconds");
        CustomerSorter.bubbleSortByAge(customers);

        System.out.println("\nSorted Customers by bubbleSortByAge:");
        for (Customer customer : customers) {
            System.out.println("\tName: " + customer.name() + ", Age: " + customer.age);
        }
        System.out.println("*** Time duration: "+(System.currentTimeMillis()-time2)+" milliseconds");
    }
}
