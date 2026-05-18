package test_threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int TOTAL_DISHES      = 10;
        final int COUNTER_CAPACITY  = 3;

        Counter counter = new Counter(COUNTER_CAPACITY);

        Thread cookThread   = new Thread(new Cook(counter, TOTAL_DISHES), "Thread-Cuisinier");
        Thread aliceThread   = new Thread(new Waiter("Alice",    counter, TOTAL_DISHES / 2), "Thread-Alice");
        Thread bobThread    = new Thread(new Waiter("Bob",      counter, TOTAL_DISHES / 2), "Thread-Bob");

        System.out.println("=== Ouverture du restaurant (comptoir max: " + COUNTER_CAPACITY + " plats) ===\n");

        cookThread.start();
        aliceThread.start();
        bobThread.start();

        cookThread.join();
        aliceThread.join();
        bobThread.join();

        System.out.println("\n=== Fin de service, tous les plats ont été servis ===");
    }
}