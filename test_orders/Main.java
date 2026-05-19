package test_orders;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AppLogger.get().info("Démarrage du système");

        OrderQueue queue = new OrderQueue(10);

        OrderGenerator gen1 = new OrderGenerator(queue, "Générateur-1");
        OrderGenerator gen2 = new OrderGenerator(queue, "Générateur-2");

        OrderPreocesseur proc1 = new OrderPreocesseur(queue, "Processeur-1");
        OrderPreocesseur proc2 = new OrderPreocesseur(queue, "Processeur-2");
        OrderPreocesseur proc3 = new OrderPreocesseur(queue, "Processeur-3");

        Thread tGen1 = new Thread(gen1);
        Thread tGen2 = new Thread(gen2);
        Thread tProc1 = new Thread(proc1);
        Thread tProc2 = new Thread(proc2);
        Thread tProc3 = new Thread(proc3);

        tProc1.start();
        tProc2.start();
        tProc3.start();
        tGen1.start();
        tGen2.start();

        Thread.sleep(5000);

        AppLogger.get().info("Arrêt des générateurs");
        gen1.stop();
        gen2.stop();
        tGen1.join();
        tGen2.join();

        proc1.notifyProductStopped();
        proc2.notifyProductStopped();
        proc3.notifyProductStopped();

        tProc1.join();
        tProc2.join();
        tProc3.join();

        AppLogger.get().info("Système arrêté");
    
    }
}
