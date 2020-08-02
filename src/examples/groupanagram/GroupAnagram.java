package examples.groupanagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(map.containsKey(sorted)) {
                final List<String> newList = new ArrayList(map.get(sorted));
                newList.add(str);
                map.put(sorted, newList);
            } else {
                map.put(sorted, Arrays.asList(str));
            }
        }

        return map.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
    }
}
