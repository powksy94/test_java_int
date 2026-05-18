package test_fibonacci;


import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fib(int n) {
        if (n <= 1) return n;

        if (memo.containsKey(n)) return memo.get(n);
        
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }
}
