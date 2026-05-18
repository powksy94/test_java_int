package test_threads;

public class Cook implements Runnable {

    private final Counter counter;
    private final int dishCount;
    private static final String[] MENU_NAMES = {"Pizza", "Pâtes", "Salade", "Burger", "Risotto"};

    public Cook(Counter counter, int dishCount) {
        this.counter = counter;
        this.dishCount = dishCount;
    }
    @Override
    public void run() {
        try {
            for (int i = 1; i <= dishCount; i++) {
                String name = MENU_NAMES[i % MENU_NAMES.length];
                Dish dish = new Dish(i, name);

                Thread.sleep((long) (Math.random() * 500 + 200));

                counter.addDish(dish);
            }
            System.out.println("[Cuisinier] *** Fin de cuisine, " + dishCount + " plats préparés ***");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[Cuisinier] Interrrompu.");
        }
    }
}