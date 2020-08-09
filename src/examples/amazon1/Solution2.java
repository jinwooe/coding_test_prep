package examples.amazon1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    public List<String> prioritizedOrders(int numOrders, List<String> orderList)
    {
        // WRITE YOUR CODE HERE
        PriorityQueue<Order> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a.metadata));
        List<Order> nonPrimeOrders = new ArrayList<>();
        List<Order> orders = convert(orderList);
        for(Order order : orders) {
            if(isPrimeOrder(order.metadata)) {
                minHeap.add(order);
            }
            else {
                nonPrimeOrders.add(order);
            }
        }

        List<String> result = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            result.add(minHeap.remove().source);
        }

        for(Order order : nonPrimeOrders) {
            result.add(order.source);
        }

        return result;
    }

    private boolean isPrimeOrder(String metadata) {
        char ch = metadata.charAt(0);
        return Character.isAlphabetic(ch);
    }

    private List<Order> convert(List<String> orderList) {
        List<Order> orders = new ArrayList<>();
        for(String s : orderList) {
            String[] split = s.split(" ");
            String[] sub = Arrays.copyOfRange(split, 1, split.length);
            final String concat = String.join("", sub);
            orders.add(new Order(split[0], s, concat));
        }

        return orders;
    }

    class Order {
        String id;
        String source;
        String metadata;
        Order(String id, String source, String metadata) {
            this.id = id;
            this.source = source;
            this.metadata = metadata;
        }
    }
}
