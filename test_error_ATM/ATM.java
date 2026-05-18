package test_error_ATM;

public class ATM {
    private double balance;
    private boolean blocked;
    private int failCount;

    public ATM(double initalBalance) {
        this.balance = initalBalance;
        this.blocked = false;
        this.failCount = 0;
    }

    public void withdraw(double amount) throws InvalidAmountException, CardBlockedException, InsufficientFundsException {
        try {
            if (blocked) throw new CardBlockedException();
            if (amount <= 0) throw new InvalidAmountException(amount);
            if (amount > balance) {
                failCount++;
                if (failCount >= 3) blocked = true;
                throw new InsufficientFundsException(balance, amount);
            }
            balance -= amount;
            System.out.println("Retrait de " + amount + "€ OK.");
            // execute du code peu importe le statut de l'exception
        } finally {
            System.out.println("Solde actuel : " + balance + "€");
        }
    }
}
