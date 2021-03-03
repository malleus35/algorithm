package graph;

import java.util.*;
import java.io.*;
import java.util.regex.*;

class Solution_1707 {
    private final int nodes;
    private final ArrayList<ArrayList<Integer>> graph;
    private final boolean[] visitedDfs;
    private final boolean[] visitedBfs;

    Solution_1707(int nodes, ArrayList<ArrayList<Integer>> graph) {
        this.nodes = nodes;
        this.graph = graph;
        this.visitedDfs = new boolean[nodes + 1];
        this.visitedBfs = new boolean[nodes + 1];

        this.visitedDfs[0] = true;
        this.visitedBfs[0] = true;

    }

    private int dfs(int node, int startNode) {
        int answer = 0;
        if(node == startNode && !visitedDfs[node]) {
            answer++;
        }
        visitedDfs[node] = true;
        int size = graph.get(node).size();
        for(int i = 0; i < size; i++) {
            int nextNode = graph.get(node).get(i);
            if(!visitedDfs[nextNode]) {
                answer += dfs(nextNode, startNode);
            }
        }
        return answer;
    }

    private void bfs() {

    }

    public String getAnswer() {
        int isYesOrNo = 0;
        for(int i = 1; i <= nodes; i++) {
            isYesOrNo += dfs(i, i);
        }
        System.out.println(isYesOrNo);
        return isYesOrNo > 1 ? "NO" : "YES";
    }
}
public class Problem_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        for(int i = 1; i <= testCase; i++) {
            int[] input = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int j = 0; j <= input[0]; j++) {
                graph.add(new ArrayList<>());
            }

            for(int k = 1; k <= input[1]; k++) {
                int[] edge = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            System.out.println(new Solution_1707(input[0], graph).getAnswer());
        }
    }
}
