package graph;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_10451 {
    private final int size;
    private final int[] graph;
    private final boolean[] checkDfs;
    private final boolean[] checkBfs;

    Solution_10451(int size, int[] graph) {
        this.size = size;
        this.graph = graph;
        this.checkDfs = new boolean[size + 1];
        this.checkBfs = new boolean[size + 1];
        this.checkDfs[0] = true;
        this.checkBfs[0] = true;
    }

    private int dfs(int node, int startNode) {
        int answer = 0;
        if(graph[node] == startNode && !checkDfs[node]) answer++;
        checkDfs[node] = true;
        if(!checkDfs[graph[node]]) {
            answer += dfs(graph[node], startNode);
        }
        return answer;
    }

    private int bfs(int startNode) {
        int lastNode = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        while(!q.isEmpty()) {
            int presentNode = q.poll();
            if(!checkBfs[presentNode]) {
                checkBfs[presentNode] = true;
                q.add(graph[presentNode]);
                lastNode = graph[presentNode];
            }
        }
        return startNode == lastNode ? 1 : 0;
    }

    public int getAnswer() {
        int answer = 0;
//        for(int i = 1; i <= size; i++) {
//            answer += dfs(i, i);
//        }
//        return answer;
//
        for(int i = 1; i <= size; i++) {
            answer += bfs(i);
        }
        return answer;
    }
}


public class Problem_10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(reader.readLine());
        for(int i = 1; i <= testCase; i++) {
            int size = Integer.parseInt(reader.readLine());
            int[] arr = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).toArray();
            System.out.println(new Solution_10451(size, arr).getAnswer());
        }
    }
}
