package parking_exercise;

public class Driver {
    // instancier attribus firstName et lastName
    private String firstName;
    private String lastName;

    // Créer constructeur de Driver
    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Méthode pour les getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // convertir to string les attribus names
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
