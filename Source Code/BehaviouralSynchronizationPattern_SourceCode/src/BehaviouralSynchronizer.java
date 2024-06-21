import java.util.concurrent.*;

// Behavioural Synchronizer interface
public interface BehaviouralSynchronizer {
    Future<Void> process(OrderProcessingTask task, Order order);
}

