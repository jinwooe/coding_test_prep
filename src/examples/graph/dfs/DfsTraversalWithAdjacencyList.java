package examples.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class DfsTraversalWithAdjacencyList {
    int numberOfVertex = 4;
    boolean[] visited = new boolean[numberOfVertex];
    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        DfsTraversalWithAdjacencyList dfsTraversalWithAdjacencyList = new DfsTraversalWithAdjacencyList();
        dfsTraversalWithAdjacencyList.init();
        dfsTraversalWithAdjacencyList.dfs(1);
    }

    public void init() {
        for(int i=1; i<numberOfVertex+1; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void dfs(int start) {
        visited[start] = true;

        List<Integer> target = list.get(start);
        for(int i : target) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }
}
