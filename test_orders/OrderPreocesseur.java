package test_orders;

public class OrderPreocesseur implements Runnable {
    private final OrderQueue queue;
    private final String name;
    private volatile boolean producersRunning = true;

    public OrderPreocesseur(OrderQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }
    // Méthode pour prévenir que les deux générateurs sont éteints
    public void notifyProductStopped() {
        producersRunning = false;
    }

    @Override
    public void run() {
        // poursuit tant qu'un des deux générateurs est activé
        while (producersRunning || !queue.isEmpty()) {
            try {
                Order order = queue.takeOrder();
                AppLogger.get().info("[" + name + "] Traitement commande : " + order);
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        AppLogger.get().info("[" + name + "] Arrêté");
    }
}
