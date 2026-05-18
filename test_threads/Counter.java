package test_threads;

import java.util.LinkedList;
import java.util.Queue;

public class Counter {
    private final Queue<Dish> queue = new LinkedList<>();
    private final int maxCapacity;

    public Counter(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addDish(Dish dish) throws InterruptedException {
        while (queue.size() == maxCapacity) {
            System.out.println("[Cuisinier] Comptoir plein (" + maxCapacity + "/" + maxCapacity + "), j'attends...");
            wait();
        }
        queue.add(dish);
        System.out.println("[Cuisinier] Déposé " + dish + " | Comptoir: " + queue.size() + "/" + maxCapacity);
        notifyAll();
    }

    public synchronized Dish takeDish() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("[Serveur]   Comptoir vide, j'attends...");
            wait();
        } 
        Dish dish = queue.poll();
        System.out.println("[Serveur]   Pris " + dish +  " | Comptoir: " + queue.size() + "/" + maxCapacity);
        notifyAll();
        return dish;
    }
}