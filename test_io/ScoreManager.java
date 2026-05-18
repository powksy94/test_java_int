package test_io;

import java.io.*;

public class ScoreManager {
    // variable non modifiable
    private static final String FILE = "scores.txt";
    
    // throws car exception susceptible d'être levée (relais de l'exception)
    public void saveScore(String player, int score) throws IOException {
            // classe permettant d'écrire par blocs et non par caractère
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, /* évite d'éraser le contenu déjà écrit*/true))) {
            writer.write(player + ":" + score);
            // saut de ligne
            writer.newLine();
        }
    }
    public void saveScore(String player, String score) throws IOException, NumberFormatException{
        int iscore = Integer.parseInt(score);
        saveScore( player, iscore);

    }

     public void saveScore(String player) throws IOException {
        saveScore( player, 0);        
    }

    public void readScores() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(":"); // découpe en tableau
                System.out.println(parts[0] + " -> " + parts[1] + " pts");
            }
        }
    }

    public String getBestScore() throws IOException {
        String best = null;
        int bestScore = Integer.MIN_VALUE;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                int score = Integer.parseInt(parts[1]); // convertir le string en int pour comparer les scores
                if (score > bestScore) {
                    bestScore = score;
                    best = parts[0] + " -> " + score + " pts";
                }
            }
        }
        return best;
    }

   
}
