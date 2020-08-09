package examples.amazon2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    PairInt IDsOfmovies(int flightDuration, int numMovies,
                        ArrayList<Integer> movieDuration) {
        // WRITE YOUR CODE HERE
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<PairDurationAndPairIndex> maxHeap = new PriorityQueue<>(
                (a, b) -> b.pairDuration.firstDuration - a.pairDuration.firstDuration);
        for (int i = 0; i < movieDuration.size(); i++) {
            map.put(movieDuration.get(i), i);
            int second = (flightDuration - 30) - movieDuration.get(i);
            if (map.containsKey(second)) {
                int movie1, movie2;
                if (movieDuration.get(i) > second) {
                    movie1 = movieDuration.get(i);
                    movie2 = second;
                } else {
                    movie1 = second;
                    movie2 = movieDuration.get(i);
                }

                maxHeap.add(new PairDurationAndPairIndex(new PairDuration(movie1, movie2),
                                                         new PairInt(i, map.get(second))));
            }
        }

        if (maxHeap.isEmpty()) {
            return new PairInt(-1, -1);
        }

        return maxHeap.poll().pairInt;
    }
// METHOD SIGNATURE ENDS

    class PairDuration {
        int firstDuration, secondDuration;

        public PairDuration(int firstDuration, int secondDuration) {
            this.firstDuration = firstDuration;
            this.secondDuration = secondDuration;
        }
    }

    class PairDurationAndPairIndex {
        PairDuration pairDuration;
        PairInt pairInt;

        public PairDurationAndPairIndex(PairDuration pairDuration, PairInt pairInt) {
            this.pairDuration = pairDuration;
            this.pairInt = pairInt;
        }
    }

    class PairInt {
        int first, second;

        PairInt() {}

        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
