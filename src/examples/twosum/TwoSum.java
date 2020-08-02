package examples.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        final int[] indices = twoSum(input, 9);
        for(int idx : indices) {
            System.out.println(idx);
        }
    }

    public static int[] twoSum(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<input.length; i++) {
            map.put(input[i], i);
            int second = target - input[i];
            if(map.containsKey(second)) {
                return new int[] {i, map.get(second)};
            }
        }

        return null;
    }
}
