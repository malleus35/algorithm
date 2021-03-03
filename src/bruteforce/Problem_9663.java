package bruteforce;

import java.io.*;
import java.util.*;

class Solution_9663 {
    private final int N;
    private final ArrayList<Point> queens;

    private class Point {
        final int y;
        final int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    Solution_9663(int size) {
        this.N = size;
        this.queens = new ArrayList<>();
    }

    private int backTrack(int depth) {
        int ret = 0;
        int currentN = queens.size();

        if (depth == N) {
            return 1;
        }

        for (int y = 0; y < N; y++) {
            if(!isAvailable(depth, currentN, y)) continue;

            queens.add(new Point(depth, y));
            ret += backTrack(depth + 1);
            queens.remove(depth);

        }
        return ret;
    }

    private boolean isAvailable(int depth, int currentN, int y) {
        for (int x = 0; x < currentN; x++) {
            Point otherQueen = queens.get(x);
            int otherQueenY = otherQueen.y;
            int otherQueenX = otherQueen.x;

            if (y == otherQueenX) return false;
            if (Math.abs(depth - otherQueenY) == Math.abs(y - otherQueenX)) return false;
        }
        return true;
    }

    public int getAnswer() {
        return backTrack(0);
    }
}

public class Problem_9663 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        System.out.println(new Solution_9663(input).getAnswer());
    }
}
