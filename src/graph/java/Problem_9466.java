package graph.java;

import java.io.*;
import java.util.regex.*;

class Solution_9446 {
    private final int len;
    private final int[] input;
    private boolean[] visited;
    private final boolean[] hasTeam;

    Solution_9446(int len, int[] input) {
        this.len = len;
        this.input = input;
        this.visited = new boolean[len + 1];
        this.hasTeam = new boolean[len + 1];
    }
    private void dfs(int student, int starter) {
        if(visited[student]) {
            if(student != starter) return;
            else {
                hasTeam[starter] = true;
                return;
            }
        }
        visited[student] = true;
        dfs(input[student], starter);
    }

    public int getAnswer() {
        for(int i = 1; i <= len; i++) {
            dfs(i, i);
        }
        int answer = 0;

        for(int i = 1; i <= len; i++) {
            if(!hasTeam[i]) answer++;
        }
        return answer;
    }
}

public class Problem_9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        for(int i = 1; i <= testCase; i++) {
            int len = Integer.parseInt(reader.readLine());
            int[] input = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).toArray();
            System.out.println(new Solution_9446(len, input).getAnswer());
        }
    }
}
