package examples.amazon2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution2 {
    List<String> largestItemAssociation(List<PairString> itemAssociation)
    {
        // WRITE YOUR CODE HERE
        if(itemAssociation == null || itemAssociation.size() == 0) {
            return null;
        }

        if(itemAssociation.size() == 1) {
            return Arrays.asList(itemAssociation.get(0).first, itemAssociation.get(0).second);
        }

        Map<String, String> map = new HashMap<>();
        for(PairString pairString : itemAssociation) {
            map.put(pairString.first, pairString.second);
        }

        PriorityQueue<List<String>> group = new PriorityQueue<>((l1, l2) -> l2.size() - l1.size());
        for(Entry<String, String> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            traverse(map, entry.getKey(), list);
            group.add(list);
        }

        final List<String> result = group.poll();
        Collections.sort(result);
        return result;
    }
// METHOD SIGNATURE ENDS

    private void traverse(Map<String, String> map, String key, List<String> list) {
        list.add(key);
        if(!map.containsKey(key)) {
            return;
        }
        traverse(map, map.get(key), list);
    }

    public static class PairString {
        String first;
        String second;

        PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

}
