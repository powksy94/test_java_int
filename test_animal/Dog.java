package test_animal;


// La classe cat récupère la classe Animal étendue
public class Dog extends Animal{
    public Dog(String name) {
        // appel du constructeur de Animal
        super(name);
    }
    // annotation de la méthode
    public String sound() {
        return "Woof!";
    }
}
