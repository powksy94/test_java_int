package test_io_diary;

import java.io.*;
import java.time.LocalDate;

public class Diary {
    private static final String FILE = "diary.txt";

    public void addEntry(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write("[" + LocalDate.now() + "] " + text);
            writer.newLine();
        }
    }

    public void readAll() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public int countEntries() throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }
}
