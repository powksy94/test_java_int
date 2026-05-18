package test_io_diary;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Diary diary = new Diary();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que voulez-vous écrire ? ");
        String input = scanner.nextLine();

        try {
            diary.addEntry(input);

            System.out.println("--- Journal ---");
            diary.readAll();

            System.out.println("--- Nombres d'entrées : " + diary.countEntries() + " ---");
        } catch (IOException e) {
            System.out.println("Erreur fichier : " + e.getMessage());
        }

        scanner.close();
    }
}
