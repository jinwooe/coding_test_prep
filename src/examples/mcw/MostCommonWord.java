package examples.mcw;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostCommonWord {
    public static void main(String[] args) {
        String str = "Bob hit a ball the hit BALL flew far after it was hit";
        System.out.println(findMostCommonWord(str));
    }

    public static String findMostCommonWord(String input) {
        String[] words = input.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        return map.entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();

    }
}
