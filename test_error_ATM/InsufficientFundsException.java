package test_error_ATM;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException( double balance, double amount) {
        // appel du constructeur Exception qui prend un String
        super("Solde insuffisant : solde=" + balance + "€, demandé=" + amount + "€");
    }
}
