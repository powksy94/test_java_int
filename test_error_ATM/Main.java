package test_error_ATM;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(200);

        double[] attempts = {50, -10, 300, 300, 300, 100, 50};
        
        for (double amount : attempts) {
            try {
                atm.withdraw(amount);
            } catch (InvalidAmountException e) {
                System.out.println("Erreur : " + e.getMessage());
            } catch (CardBlockedException e) {
                System.out.println("Erreur : " + e.getMessage());
                break;
            } catch (InsufficientFundsException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
            System.out.println("---");
        }
    }
    
}
