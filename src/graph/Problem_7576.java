package graph;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class Solution_7576 {
    private final int maxColumn;
    private final int maxRow;
    private final int[][] graph;
    private final int[][] visited;
    private final ArrayList<Position> startingPoints;
    private final int[] dy = {1, -1, 0, 0};
    private final int[] dx = {0, 0, 1, -1};

    private class Position {
        private final int y;
        private final int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    Solution_7576(int maxColumn, int maxRow, int[][] graph) {
        this.maxColumn = maxColumn;
        this.maxRow = maxRow;
        this.graph = graph;
        this.visited = graph.clone();
        this.startingPoints = new ArrayList<>();

        for(int i = 1; i <= maxColumn; i++) {
            for(int j = 1; j <= maxRow; j++) {
                if(graph[i][j] == 1) {
                    startingPoints.add(new Position(i,j));
                }
            }
        }
    }


    private void bfs() {
        Queue<Position> q = new LinkedList<>();
        for(int i = 0; i < startingPoints.size(); i++)
            q.add(startingPoints.get(i));
        while(!q.isEmpty()) {
            Position present = q.poll();
            for(int i = 0; i < 4; i++) {
                int nexty = present.y + dy[i];
                int nextx = present.x + dx[i];
                if(nexty <= 0 || nextx <= 0 || nexty > maxColumn || nextx > maxRow) continue;
                if(graph[nexty][nextx] == -1) continue;
                if(visited[nexty][nextx] > 0) continue;
                else {
                    visited[nexty][nextx] = visited[present.y][present.x] + 1;
                    q.add(new Position(nexty, nextx));
                }
            }
        }
    }

    public int getAnswer() {
        int answer = 0;
        bfs();
        for(int i = 1; i <= maxColumn; i++) {
            answer = Math.max(answer, Arrays.stream(visited[i]).max().getAsInt());
        }
//        for(int i = 1; i <= maxColumn; i++) {
//            for(int j = 1; j <= maxRow; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }
        for(int i = 1; i <= maxColumn; i++) {
            for(int j = 1; j <= maxRow; j++) {
                if(visited[i][j] == 0) return -1;
            }
        }
        return answer - 1;
    }
}

public class Problem_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        int[][] graph = new int[input[1] + 1][input[0] + 1];
        for(int i = 1; i <= input[1]; i++) {
            graph[i] = Pattern.compile(" ").splitAsStream("0 "+ reader.readLine()).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(new Solution_7576(input[1], input[0], graph).getAnswer());
    }
}
