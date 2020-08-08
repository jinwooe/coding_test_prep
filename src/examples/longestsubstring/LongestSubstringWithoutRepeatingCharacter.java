package examples.longestsubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("abcdefg"));
        System.out.println(longestSubstring("aaaaaaaaa"));
    }

    public static int longestSubstring(String input) {
        int max = 0;
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if(map.containsKey(ch)) {
                max = Integer.max(max, map.size());
                map = new HashMap<>();
                continue;
            }

            map.put(ch, ch);
        }

        return Integer.max(max, map.size());
    }
}
