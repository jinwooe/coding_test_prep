package examples.topkelements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KThLargestElement {
    public static void main(String[] args) {
        KThLargestElement kThLargestElement = new KThLargestElement();
        int[] input = {3,2,1,5,6, 4};
        final int kthLargest = kThLargestElement.findKthLargest(input, 2);
        System.out.println(kthLargest);

        final int[] result = kThLargestElement.findTopK(input, 2);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    public int[] findTopK(int[] input, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int i : input) {
            maxHeap.add(i);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> topKList = new ArrayList<>(maxHeap);
        Collections.reverse(topKList);

        int[] result = new int[topKList.size()];
        for(int i=0; i<topKList.size(); i++) {
            result[i] = topKList.get(i);
        }

        return result;
    }
}
