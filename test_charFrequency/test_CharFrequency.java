package test_charFrequency;

import java.util.HashMap;
import java.util.Map;

public class test_CharFrequency {
    public static void main(String [] args) {
        Map<Character, Integer> freq = charFrequency("banana");
        System.out.println(freq);
    }

    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        return map;
    }
}
