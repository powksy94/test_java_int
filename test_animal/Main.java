package test_animal;



public class Main {
    // méthode main pour intégrer des arguments de type String
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Rex"), new Cat("Whiskers"), new Dog("Buddy") };
        // boucle de pointage 
        for (Animal a : animals) {
            a.describe();
        }
    }
}
