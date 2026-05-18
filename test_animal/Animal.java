package test_animal;


// Animal n'est pas instanciable
public abstract class Animal {
    protected String name;

public Animal() {}

// Constructeur de Animal
    public Animal(String name) {
        this.name = name;
    }
    // méthode abstraite à overrider obligatoirement pour chaque sous-classes
    public abstract String sound();
    // héritage concret de la fonction
    public void describe() {
        System.out.println(name + " dit : " + sound());
    }
}
