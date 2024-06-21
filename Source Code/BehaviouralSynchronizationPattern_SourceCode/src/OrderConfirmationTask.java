// Concrete implementation of a task representing order confirmation
public class OrderConfirmationTask implements OrderProcessingTask {
    @Override
    public void process(Order order) {
        System.out.println("Processing order confirmation for order ID: " + order.getOrderId());
        // Simulate order confirmation process
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order confirmation processed for order ID: " + order.getOrderId());
    }
}
