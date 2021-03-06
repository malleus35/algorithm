package graph.java;

import java.util.*;
import java.io.*;
import java.util.regex.*;

class Solution_2667 {
    private final int length;
    private final int[][] graph;
    private final int[][] visited;
    private final int[] dy = {1, -1, 0, 0};
    private final int[] dx = {0, 0, 1, -1};
    private final ArrayList<Point> buildings = new ArrayList<>();
    private final int[] aptNums = new int[1001];

    private class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    Solution_2667(int length, int[][] graph) {
        this.length = length;
        this.graph = graph;
        this.visited = new int[length + 1][length + 1];

        for(int i = 1; i <= length; i++) {
            for(int j = 1; j <= length; j++) {
               if(this.graph[i][j] == 1)
                   buildings.add(new Point(i,j));
            }
        }
    }

    private void dfs(int y, int x, int apt) {
        if(y <= 0 || x <= 0 || y > length || x > length) return;
        if(graph[y][x] == 0) return;
        if(visited[y][x] > 0) return;
        visited[y][x] = apt;
        for(int i = 0; i < 4; i++) {
            int nexty = y + dy[i];
            int nextx = x + dx[i];
            dfs(nexty, nextx, apt);
        }
    }

    public String getAnswer() {
        StringBuilder builder = new StringBuilder();
        int buildingNum = buildings.size();
        for(int i = 0; i < buildingNum; i++) {
            Point p = buildings.get(i);
            dfs(p.y, p.x, i + 1);
        }

        int aptNum = 0;
        for(int j = 1; j <= length; j++) {
            for(int k = 1; k <= length; k++) {
                if(visited[j][k] != 0) {
                    aptNums[visited[j][k]]++;
                }
            }
        }
        for(int l = 0; l <= 1000; l++)
            if(aptNums[l] != 0) aptNum++;

        builder.append(aptNum).append("\n");
        Arrays.sort(aptNums);
        for(int i = 1; i <= 1000; i++) {
            if(aptNums[i] != 0)
                builder.append(aptNums[i]).append("\n");
        }
        return builder.toString();
    }
}

public class Problem_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());

        int[][] graph = new int[length + 1][length + 1];
        for(int i = 1; i <= length; i++) {
            int[] input = Pattern.compile("").splitAsStream("0" + reader.readLine()).mapToInt(Integer::parseInt).toArray();
            graph[i] = input;
        }
        System.out.print(new Solution_2667(length, graph).getAnswer());
    }
}
//"^[0-9]*$"