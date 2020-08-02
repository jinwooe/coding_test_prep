package examples.dailytemperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.asList(dailyTemperatures(input)));
    }

    public static Integer[] dailyTemperatures(int[] input) {
        Integer[] ans = new Integer[input.length];
        Stack<Integer> stack = new Stack();
        for (int i = input.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && input[i] >= input[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
