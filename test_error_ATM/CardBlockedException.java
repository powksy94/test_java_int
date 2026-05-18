package test_error_ATM;

public class CardBlockedException extends Exception {
    public CardBlockedException() {
        super("Carte bloquée après trop d'échecs");
    }
}