package main.hashmap;

import java.util.*;

public class CountRepeatedWords {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "apple", "orange", "orange", "apple");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " раза");
            } else {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " раз");
            }
        }
    }
}
