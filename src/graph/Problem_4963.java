package graph;

import java.util.*;
import java.io.*;
import java.util.regex.*;

class Solution_4963 {
    private final int column;
    private final int row;
    private final int[][] graph;
    private final int[][] visited;
    private final int[] dy = {1,1,1,-1,-1,-1,0,0};
    private final int[] dx = {1,-1,0,0,-1,1,1,-1};
    private final ArrayList<Point> startingPoints = new ArrayList<>();

    Solution_4963(int column, int row, int[][] graph) {
        this.column = column;
        this.row = row;
        this.graph = graph;
        this.visited = new int[column + 1][row + 1];

        for(int i = 1; i <= column; i++) {
            for(int j = 1; j <= row; j++) {
                if(graph[i][j] == 1)
                    startingPoints.add(new Point(i,j));
            }
        }
    }

    private class Point {
        int y;
        int x;
//        int value;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
//            this.value = value;
        }
    }

    private void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            Point present = q.poll();
            for(int i = 0; i < 8; i++) {
                int nextY = present.y + dy[i];
                int nextX = present.x + dx[i];
                if(nextY <= 0 || nextX <= 0 || nextY > column || nextX > row) continue;
                if(graph[nextY][nextX] == 0) continue;
                if(visited[nextY][nextX] == 1) continue;
                else {
                    visited[nextY][nextX] = 1;
                    visited[present.y][present.x] = 1;
                    q.add(new Point(nextY, nextX));
                }
            }
        }
    }

    public int getAnswer() {
        int cnt = 0;
        for(int i = 0; i < startingPoints.size(); i++) {
            Point now = startingPoints.get(i);
            if(visited[now.y][now.x] == 0) {
                bfs(now);
                cnt++;
            }
        }
        return cnt;
    }
}

public class Problem_4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while((input = reader.readLine()) != null) {
                int[] tmp = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
                if(tmp[0] == 0 && tmp[1] == 0) return;
                int[][] graph = new int[tmp[1] + 1][];
                for(int i = 1; i <= tmp[1]; i++) {
                    graph[i] = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).toArray();
                }
                System.out.println(new Solution_4963(tmp[1], tmp[0], graph).getAnswer());
        }
    }
}
