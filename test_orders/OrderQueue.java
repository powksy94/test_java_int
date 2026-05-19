package test_orders;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderQueue {
    // Méthode centralisée de gestion de la file
    private final BlockingQueue<Order> queue;

    public OrderQueue(int capacity) {
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    public void addOrder(Order order) throws InterruptedException {
        // thread producteur se met en pause tant que la file est pleine.
        queue.put(order);
    }

    public Order takeOrder() throws InterruptedException {
         // thread consommateur se met en pause tant que la file est pleine.
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
