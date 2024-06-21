// Concrete implementation of a task representing order shipment
public class OrderShipmentTask implements OrderProcessingTask {
    @Override
    public void process(Order order) {
        System.out.println("Processing order shipment for order ID: " + order.getOrderId());
        // Simulate order shipment process
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order shipment processed for order ID: " + order.getOrderId());
    }
}
