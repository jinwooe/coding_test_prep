package examples.topkelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] input = {1,1,1,2,2,3};
        final int[] result = topKFrequentElements.topKFrequent(input, 2);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> topk = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= k) {
                topk.add(entry.getKey());
            }
        }

        int[] result = new int[topk.size()];
        for(int i=0; i<topk.size(); i++) {
            result[i] = topk.get(i);
        }

        return result;
    }
}
