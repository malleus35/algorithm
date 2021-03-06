package graph.java;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

class Solution_11724 {
    private final int nodes;
    private final ArrayList<ArrayList<Integer>> graph;
    private final boolean[] checkDfs;
    private final boolean[] checkBfs;

    Solution_11724(int nodes, ArrayList<ArrayList<Integer>> graph) {
        this.nodes = nodes;
        this.graph = graph;
        this.checkDfs = new boolean[nodes + 1];
        this.checkBfs = new boolean[nodes + 1];

        this.checkDfs[0] = true;
        this.checkBfs[0] = true;
    }

    private void dfs(int node) {
        checkDfs[node] = true;
        int n = graph.get(node).size();
        for(int i = 0; i < n; i++) {
            int nextNode = graph.get(node).get(i);
            if(!checkDfs[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    private void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        while(!q.isEmpty()) {
            int presentNode = q.poll();
            int size = graph.get(presentNode).size();
            for(int i = 0; i < size; i++) {
                int nextNode = graph.get(presentNode).get(i);
                if(!checkBfs[nextNode]) {
                    q.add(nextNode);
                    checkBfs[nextNode] = true;
                }
            }
        }
    }

    public int getAnswer() {
        int answer = 0;
        for(int i = 1; i <= nodes; i++) {
            if(!checkBfs[i]) {
                bfs(i);
                answer++;
            }
//            if(!checkDfs[i]) {
//                dfs(i);
//                answer++;
//            }
        }
        return answer;
    }
}

public class Problem_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= input[0]; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i <= input[1]; i++) {
            int[] tmp = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
            graph.get(tmp[0]).add(tmp[1]);
            graph.get(tmp[1]).add(tmp[0]);
        }

        System.out.println(new Solution_11724(input[0], graph).getAnswer());
    }
}
