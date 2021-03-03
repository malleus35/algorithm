package graph;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

class Solution_1260 {
    private final int nodes;
    private final int edges;
    private final int startNode;
    private final int[][] graph;
    private final boolean[] checkDfs;
    private final boolean[] checkBfs;

    Solution_1260(int nodes, int edges, int startNode, int[][] graph) {
        this.nodes = nodes;
        this.edges = edges;
        this.startNode = startNode;
        this.graph = graph;
        this.checkDfs = new boolean[nodes + 1];
        this.checkBfs = new boolean[nodes + 1];

        this.checkDfs[0] = true;
        this.checkBfs[0] = true;
    }

    private void dfs(int node, StringBuilder builder) {
        checkDfs[node] = true;
        builder.append(node).append(" ");
        for(int i = 1; i <= this.nodes; i++) {
            if(graph[node][i] == 1 && !checkDfs[i]) {
                dfs(i, builder);
            }
        }
    }

    private void bfs(StringBuilder builder) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        checkBfs[startNode] = true;
        builder.append(startNode).append(" ");
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 1; i <= nodes; i++) {
                if(graph[now][i] == 1 && !checkBfs[i]) {
                    checkBfs[i] = true;
                    q.add(i);
                    builder.append(i).append(" ");
                }
            }
        }
    }

    public String getAnswer() {
        StringBuilder builder = new StringBuilder();
        dfs(startNode, builder);
        builder.append("\n");
        bfs(builder);
        return builder.toString();
    }
}

public class Problem_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] edges = new int[input[0] + 1][input[0] + 1];
        for(int i = 1; i <= input[1]; i++) {
            int[] tmp = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
            edges[tmp[0]][tmp[1]] = 1;
            edges[tmp[1]][tmp[0]] = 1;
        }

        Solution_1260 solution = new Solution_1260(input[0], input[1], input[2], edges);
        System.out.println(solution.getAnswer());
    }
}
