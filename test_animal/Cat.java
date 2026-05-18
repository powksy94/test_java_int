package test_animal;


// La classe cat récupère la classe Animal étendue
public class Cat extends Animal {

   

    // constructeur
    public Cat(String name) {
        // appel du constructeur du père
        super(name);

        //this.name = name + "!";

    }


    // annotation de la méthode
    @Override
    public String sound() {
        return "Miaou!";
    }
}
