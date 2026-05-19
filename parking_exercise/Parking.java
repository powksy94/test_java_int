package parking_exercise;

import java.util.ArrayList;

public class Parking {

    // Instancier les attributs voiture garées et voiture sorties ( tout deux des tableaux)
    private ArrayList<Car> parkedCars;
    private ArrayList<Car> exitedCars;

    // Créer constructeur parking en initialisant les deux listes
    public Parking() {
        parkedCars = new ArrayList<>();
        exitedCars = new ArrayList<>();
    }

    // Méthode entrée : ajout de voitures garées
    public void enter(Car car) {
        parkedCars.add(car);
    }

    // Méthode sortie : soustraction de voitures garées et ajout de voitures sorties
    public void exit(Car car) {
        parkedCars.remove(car);
        exitedCars.add(car);
    }

    // Affichage de chaque voiture du tableau voitures garées
    public void displayParked() {
        System.out.println("=== Parked cars ===");
        for (Car car : parkedCars) {
            System.out.println(car);
        }
    }

    // Affichage de chaque voiture du tableau voitures sorties
    public void displayExited() {
        System.out.println("=== Exited cars ===");
        for (Car car : exitedCars) {
            System.out.println(car);
        }
    }
}
