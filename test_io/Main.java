package test_io;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ScoreManager manager = new ScoreManager();

        try {
            manager.saveScore("Alice", 1500);
            manager.saveScore("Bob", 3200);
            manager.saveScore("Chalie", "tata");

            System.out.println("--- Scores ---");
            manager.readScores();

            System.out.println("--- Meilleur ---");
            System.out.println(manager.getBestScore());
        } catch (IOException e) {
            System.out.println("Erreur fichier : " + e.getMessage());
        } catch  (NumberFormatException e) {
            System.out.println("Erreur score");
        }
    }
}
