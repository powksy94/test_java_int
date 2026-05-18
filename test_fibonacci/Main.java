package test_fibonacci;


public class Main {
    public static void main(String[] args) {
        int[] tests = {0, 1, 6, 10, 50, 70};
        for (int n : tests) {
            System.out.println("fib(" + n + ") = " + Fibonacci.fib(n));
        }
    }
}
