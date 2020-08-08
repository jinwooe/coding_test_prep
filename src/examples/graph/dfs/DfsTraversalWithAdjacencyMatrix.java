package examples.graph.dfs;

public class DfsTraversalWithAdjacencyMatrix {
    int numberOfVertex = 4;
    int[][] matrix = new int[numberOfVertex + 1][numberOfVertex + 1]; // +1 을 해주는 이유는 index 를 0 이 아닌 1부터 시작하기 위함
    boolean[] visited = new boolean[numberOfVertex + 1];

    public static void main(String[] args) {
        DfsTraversalWithAdjacencyMatrix dfsTraversal = new DfsTraversalWithAdjacencyMatrix();
        dfsTraversal.dfs(1);

        // matrix 초기화
        // matrix[i][j] = matrix[j][i] = 1
    }
    public void dfs(int start) {
        visited[start] = true;
        System.out.println(start + " ");

        for(int i=1; i<numberOfVertex + 1; i++) {
            if(matrix[start][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }
}
