package test_bankaccount;



public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Alice", 1000, 0.05);
        savings.deposit(500);
        savings.withdraw(200);
        savings.applyInterest();
        System.out.println(savings);

        System.out.println("---");

        CheckingAccount checking = new CheckingAccount("Bob", 200, 300);
        checking.deposit(100);
        checking.withdraw(500);
        checking.withdraw(200);
        System.out.println(checking);
    }
}
