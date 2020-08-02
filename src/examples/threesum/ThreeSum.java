package examples.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        final Integer[][] integers = threeSum(input);
        for(Integer[] ints : integers) {
            System.out.println(ints[0] + " " + ints[1] + " " + ints[2]);
        }
    }

    // select 3 element that those sum is 0
    // [-1, 0, 1]
    // [-1, -1, 2]
    public static Integer[][] threeSum(int[] input) {
        Arrays.sort(input);
        List<Integer[]> results = new ArrayList<>();

        for(int i = 0; i < input.length - 2; i++) {
            if(i > 0 && input[i] == input[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = input.length - 1;
            while(left < right) {
                int sum = input[i] + input[left] + input[right];
                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
                    results.add(new Integer[]{input[i], input[left], input[right]});

                    // 다음 원소의 값이 같으면 스킵
                    while(left < right && input[left] == input[left+1]) {
                        left++;
                    }
                    // 다음 원소의 값이 같으면 스킵
                    while(left < right && input[right] == input[right-1]) {
                        right--;
                    }

                    // left, right 모두 스킵
                    left++;
                    right--;
                }
            }
        }

        final Integer[][] integers = results.toArray(new Integer[results.size()][3]);
        return integers;
    }
}
