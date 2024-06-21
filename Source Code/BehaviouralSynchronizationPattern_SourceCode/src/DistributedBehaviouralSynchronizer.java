import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

// Concrete implementation of Behavioural Synchronizer
public class DistributedBehaviouralSynchronizer implements BehaviouralSynchronizer {
    private final ExecutorService executorService;
    private final List<Future<Void>> futures;

    public DistributedBehaviouralSynchronizer(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
        this.futures = new ArrayList<>();
    }

    @Override
    public Future<Void> process(OrderProcessingTask task, Order order) {
        Future<Void> future = executorService.submit(() -> {
            task.process(order);
            return null;
        });
        futures.add(future);
        return future;
    }

    // Shutdown the executor service
    public void shutdown() {
        executorService.shutdown();
    }

    // Wait for all tasks to complete
    public void awaitCompletion() {
        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}