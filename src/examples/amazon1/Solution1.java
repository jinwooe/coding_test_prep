package examples.amazon1;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        // WRITE YOUR CODE HERE
        List<List<Integer>> result = new ArrayList<>();

        List<Route> forwardRoutes = convert(forwardRouteList);
        List<Route> returnRoutes = convert(returnRouteList);
        int min = Integer.MAX_VALUE;

        List<Integer> temp = new ArrayList<>();
        for(Route forwardRoute : forwardRoutes) {
            for(Route returnRoute : returnRoutes) {
                if(maxTravelDist - (forwardRoute.distance + returnRoute.distance) >= 0) {
                    if(maxTravelDist - (forwardRoute.distance + returnRoute.distance) < min) {
                        temp = new ArrayList<>();
                        temp.add(forwardRoute.id);
                        temp.add(returnRoute.id);
                    }
                    if (min == 0) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(forwardRoute.id);
                        pair.add(returnRoute.id);
                        result.add(pair);
                    }
                }
            }
        }

        if(result.size() == 0) {
            result.add(temp);
        }

        return result;
    }
    // METHOD SIGNATURE ENDS

    private List<Route> convert (List<List<Integer>> list) {
        List<Route> routes = new ArrayList<>();
        for(List<Integer> pair : list) {
            routes.add(new Route(pair.get(0), pair.get(1)));
        }

        return routes;
    }

    class Route {
        int id;
        int distance;
        Route(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

}
