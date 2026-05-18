package test_error_ATM;

public class InvalidAmountException extends Exception {
    public InvalidAmountException( double amount) {
        super("Montant invalide : " + amount + "€");
    }
}
