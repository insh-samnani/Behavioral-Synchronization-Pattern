import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Main class to run the program
public class ECommerceSystem {
    public static void main(String[] args) {
        // Create the Behavioural Synchronizer with 8 worker threads
        BehaviouralSynchronizer synchronizer = new DistributedBehaviouralSynchronizer(8);

        // Create multiple customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(synchronizer));
        customers.add(new Customer(synchronizer));
        customers.add(new Customer(synchronizer));

        // Simulate a dynamic product catalog
        List<Order> orders = generateRandomOrders(10);

        // Place orders for each customer
        for (Customer customer : customers) {
            for (Order order : orders) {
                customer.placeOrder(order);
            }
        }

        // Shutdown the Behavioural Synchronizer after tasks are submitted
        ((DistributedBehaviouralSynchronizer) synchronizer).shutdown();

        // Wait for all tasks to complete
        ((DistributedBehaviouralSynchronizer) synchronizer).awaitCompletion();
    }

    // Method to generate random orders for simulation
    private static List<Order> generateRandomOrders(int numOrders) {
        List<Order> orders = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= numOrders; i++) {
            String customerName = "Customer" + (random.nextInt(100) + 1);
            double totalPrice = random.nextDouble() * 500.0; // Random total price up to $500
            orders.add(new Order(i, customerName, totalPrice));
        }
        return orders;
    }
}

