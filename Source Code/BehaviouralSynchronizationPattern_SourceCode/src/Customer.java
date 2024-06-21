// Client class representing a customer in the e-commerce system
public class Customer {
    private final BehaviouralSynchronizer behaviouralSynchronizer;

    public Customer(BehaviouralSynchronizer behaviouralSynchronizer) {
        this.behaviouralSynchronizer = behaviouralSynchronizer;
    }

    // Method for submitting order processing tasks
    public void placeOrder(Order order) {
        OrderProcessingTask confirmationTask = new OrderConfirmationTask();
        OrderProcessingTask shipmentTask = new OrderShipmentTask();

        behaviouralSynchronizer.process(confirmationTask, order);
        behaviouralSynchronizer.process(shipmentTask, order);
    }
}