package examples.amazondemo;

import java.util.ArrayList;
import java.util.List;

public class CellStates {
    public static void main(String[] args) {
        CellStates solution = new CellStates();
        int[] states = {1,0,0,0,0,1,0,0};
        final List<Integer> result = solution.cellCompete(states, 1);
        System.out.println(result);

        int[] states2 = {1,1,1,0,1,1,1,1};
        System.out.println(solution.cellCompete(states2, 2));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] src = states;
        int[] dest = new int[states.length];
        for(int i=0; i<days; i++) {
            int left;
            int right;
            for(int j=0; j<src.length; j++) {
                left = j - 1;
                right = j + 1;
                if(j == 0) {
                    left = 0;
                } else {
                    left = src[left];
                }
                if(j == src.length - 1) {
                    right = 0;
                } else {
                    right = src[right];
                }
                if(left == right) {
                    dest[j] = 0;
                } else {
                    dest[j] = 1;
                }
            }

            src = new int[states.length];
            System.arraycopy(dest, 0, src, 0, dest.length);
        }

        List<Integer> result = new ArrayList<>();
        for(int i : src) {
            result.add(i);
        }

        return result;
    }
}
