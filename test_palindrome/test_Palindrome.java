package test_palindrome;


public class test_Palindrome {
    public static void main(String [] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
