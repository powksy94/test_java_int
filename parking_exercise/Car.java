package parking_exercise;

public class Car {

    // instancier attributs : plaque d'immatriculation, marque, chauffeur ( de type Driver, car peut être null)
    private String licensePlate;
    private String brand;
    private Driver driver;

    // Créer constructeur car (sans chauffeur)
    public Car(String licensePlate, String brand) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.driver = null;
    }

    // Méthode pour les getters et les setter pour driver
    public String getLicensePlate() { return licensePlate; }
    public String getBrand() { return brand; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver;}

    // convertir to String les attributs voiture + chauffeur (ou sans chauffeur)
    @Override
    public String toString() {
        String driverInfo = (driver != null) ? driver.toString() : "no driver";
        return brand + " (" + licensePlate + ") - Driver: " + driverInfo;
    }
}
