package graph.java;

import java.util.*;
import java.util.regex.*;
import java.io.*;

class Solution_2178 {
    private final int column;
    private final int row;
    private final int[][] graph;
    private final int[][] visited;
    private final int[] dy = {1, -1, 0, 0};
    private final int[] dx = {0, 0, 1, -1};

    private class Point {
        int y;
        int x;
        int len;

        Point(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }

    Solution_2178(int column, int row, int[][] graph) {
        this.column = column;
        this.row = row;
        this.graph = graph;
        this.visited = new int[column + 1][row + 1];
    }

    private void dfs(int y, int x, int len) {
        if(y <= 0 || x <= 0 || y > column || x > row) return;
        if(graph[y][x] == 0) return;
        if(visited[y][x] != 0) return;
        visited[y][x] = len;
        for(int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            dfs(nextY, nextX, len + 1);
        }
    }

    private void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1,1, 1));
        while(!q.isEmpty()) {
            Point nowPoint = q.poll();
            for(int i = 0; i < 4; i++) {
                int nextY = nowPoint.y + dy[i];
                int nextX = nowPoint.x + dx[i];
                if(nextY <= 0 || nextX <= 0 || nextY > column || nextX > row) continue;
                if(graph[nextY][nextX] == 0) continue;
                if(visited[nextY][nextX] != 0) continue;
                visited[nextY][nextX] = nowPoint.len + 1;
                q.add(new Point(nextY, nextX, nowPoint.len + 1));
            }
        }
    }

    public int getAnswer() {
        bfs();
        return visited[column][row];
    }
}

public class Problem_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        int[][] graph = new int[input[0] + 1][input[1] + 1];

        for(int i = 1; i <= input[0]; i++) {
            graph[i] = Pattern.compile("").splitAsStream("0"+reader.readLine()).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(new Solution_2178(input[0], input[1], graph).getAnswer());
    }
}
