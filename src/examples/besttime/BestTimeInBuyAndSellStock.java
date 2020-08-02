package examples.besttime;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class BestTimeInBuyAndSellStock {
    public static void main(String[] args) {
        int input[] = {7, 1, 5, 3, 6, 4};
        System.out.println(bestProfit(input));
    }

    public static int bestProfit(int[] input) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i : input) {
            min = min(min, i);
            maxProfit = max(maxProfit,i - min);
        }

        return maxProfit;
    }
}
