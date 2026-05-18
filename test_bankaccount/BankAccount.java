package test_bankaccount;



public class BankAccount {
    /*  variable proteger mais accessible pour les sous-classes
        et les classes qui étendent la classe parente*/
    protected String owner;
    protected double balance;

    // Construteur le bankaccount
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    // Méthode de dépôt
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Dépôt refusé : montant doit être positif");
            return;
        }
        balance += amount;
        System.out.println("Dépot de " + amount + "€ -> solde :" + balance + "€");
    }

    // Méthode de retrait
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Retrait refusé : solde insuffisant.");
        } else {
            balance -= amount;
            System.out.println("Retrait de " + amount + "€ -> solde : " + balance + "€");
        }
    }

    // Annotation text propriétaire | solde en euros
    @Override
    public String toString() {
        return owner + " | solde : " + balance + "€";
    }
}
