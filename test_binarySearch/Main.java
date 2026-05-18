package test_binarySearch;


public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        int[][] tests = {
                { 7, 3 }, { 11, 5 }, { 1, 0 }, { 13, 6 }, { 4, -1 }
        };
        for (int[] test : tests) {
            int result = BinarySearch.search(arr, test[0]);
            int excepted = test[1];
            System.out.println("search(" + test[0] + ") = " + result
                    + (result == excepted ? "✓" : " ✗ attendu" + excepted));
        }
    }
}
