import java.util.List;

public class CustomerSorter {


    // QuickSort to sort customers by age
    public static void quickSortByAge(Customer[] customers, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(customers, low, high);
            quickSortByAge(customers, low, pivotIndex - 1);
            quickSortByAge(customers, pivotIndex + 1, high);
        }
    }

    public static int partition(Customer[] customers, int low, int high) {
        int pivotAge = customers[high].age;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (customers[j].age < pivotAge) {
                i++;
                Customer temp = customers[i];
                customers[i] = customers[j];
                customers[j] = temp;
            }
        }

        Customer temp = customers[i + 1];
        customers[i + 1] = customers[high];
        customers[high] = temp;

        return i + 1;
    }


    // Bubble Sort to sort customers by age
    public static void bubbleSortByAge(Customer[] customers) {
        int n = customers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (customers[j].age > customers[j + 1].age) {
                    Customer temp = customers[j];
                    customers[j] = customers[j + 1];
                    customers[j + 1] = temp;
                }
            }
        }
    }
}
