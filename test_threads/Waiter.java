package test_threads;

public class Waiter implements Runnable {

    private final String name;
    private final Counter counter;
    private final int dishesToServe;

    public Waiter(String name, Counter counter, int dishesToServe) {
        this.name = name;
        this.counter = counter;
        this.dishesToServe = dishesToServe;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < dishesToServe; i++) {
                Dish dish = counter.takeDish();
                
                Thread.sleep((long) (Math.random() * 800 + 300));

                System.out.println("[" + name + "] Servi " + dish + " à un client.");
            }
            System.out.println("[" + name + "] *** Fin de service ***");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + name + "] Interrompu.");
        }
    }
}