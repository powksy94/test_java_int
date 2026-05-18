package test_bankaccount;



public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String owner, double initialBalance, double overdraftLimit) {
        super(owner, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Retrait refusé : limit de découvert dépassé.");
        } else {
            balance -= amount;
            System.out.println("Retrait de " + amount + "€ -> solde : " + balance + "€");
        }
    }
}
