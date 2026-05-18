package test_bankaccount;


// Class enfante qui etend la classe parente
public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Construteur de la méthode enfante
    public SavingsAccount(String owner, double initalBalance, double interestRate) {
        // utilisation des variables d'instances du constructeur parent
        super(owner, initalBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Intérêts appliqués : +" + interest + "€ -> solde : " + balance + "€");
    }
}