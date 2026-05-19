package test_orders;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderGenerator implements Runnable {
    private static final String[] PRODUCTS = {"Laptop", "Phone", "Tablet", "Monitor", "Keyboard"};
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final OrderQueue queue;
    private final String name;
    // permet que le Main agisse sur la méthode stop 
    private volatile boolean running = true;

    public OrderGenerator(OrderQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            try {
                String product = PRODUCTS[random.nextInt(PRODUCTS.length)];
                int quantity = random.nextInt(10) + 1;
                Order order = new Order(counter.incrementAndGet(), product, quantity);
                queue.addOrder(order);
                AppLogger.get().info("[" + name + "] Commande générée : " + order);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        AppLogger.get().info("[" + name + "] Arrêté");
    }
}
