package parking_exercise;

public class Main {

    public static void main(String[] args) {
        
        // Création objet chauffeur
        Driver driver1 = new Driver("Alice", "Martin");
        Driver driver2 = new Driver("Bob", "Dupont");
        Driver driver3 = new Driver("Clara", "Durand");

        // Création objet voiture

        Car car1 = new Car("AB-123-CD", "Renault");
        Car car2 = new Car("EF-456-GH", "Peugeot");
        Car car3 = new Car("IJ-789-KL", "Toyota");

        // Création parking
        Parking parking = new Parking();

        // Application de la méthode entrée
        parking.enter(car1);
        parking.enter(car2);
        parking.enter(car3);

        // Ajout d'un chauffeur à une voiture
        car1.setDriver(driver1);
        car2.setDriver(driver2);
        car3.setDriver(driver3);

        // Afficher les voitures garées
        parking.displayParked();

        // Retirer une voiture de voitures garées et ajouter une voiture à voitures sorties
        parking.exit(car1);

        // Afficher les voitures garées
        parking.displayParked();

        // Afficher les voitures sorties
        parking.displayExited();

        // Assigner un autre chauffeur à la voiture
        car1.setDriver(driver3);

        // Ajouter la voiture au tableau voitures garées
        parking.enter(car1);

        // Afficher les voitures garées
        parking.displayParked();
    }
}
