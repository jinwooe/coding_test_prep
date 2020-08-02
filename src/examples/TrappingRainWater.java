package examples;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] heights) {
        int volume = 0;
        int left = 0, right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];

        while(left < right) {
            leftMax = Math.max(heights[left], leftMax);
            rightMax = Math.max(heights[right], rightMax);

            if(leftMax <= rightMax) {
                volume += leftMax - heights[left];
                left++;
            } else {
                volume += rightMax - heights[right];
                right--;
            }
        }

        return volume;
    }
}
