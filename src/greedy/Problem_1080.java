package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_1080 {
    private final int column;
    private final int row;
    private final boolean[][] matrixA;
    private final boolean[][] matrixB;

    Solution_1080(int column, int row, boolean[][] matrixA, boolean[][] matrixB) {
        this.column = column;
        this.row = row;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    private int flip(boolean[][] matrixA, int y, int x) {
        for(int i = y; i <= y + 2; i++) {
            for(int j = x; j <= x + 2; j++) {
                matrixA[i][j] = !matrixA[i][j];
            }
        }
        return 1;
    }

    private boolean isSame(boolean[][] matrixA, boolean[][] matrixB) {
        for(int i = 1; i <= column; i++) {
            for(int j = 1; j <= row; j++) {
                if(matrixA[i][j] != matrixB[i][j]) return false;
            }
        }
        return true;
    }

    public int getAnswer() {
        int answer = 0;
        if(column < 3 || row < 3)
            return isSame(matrixA, matrixB) ? answer : -1;

        for(int i = 1; i <= column - 2; i++) {
            for(int j = 1; j <= row - 2; j++) {
                if(matrixA[i][j] ^ matrixB[i][j])
                    answer += flip(matrixA, i, j);
            }
        }
        return isSame(matrixA, matrixB) ? answer : -1;
    }
}

public class Problem_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        boolean[][] matrixA = setMatrix(reader, sizes[0], sizes[1]);
        boolean[][] matrixB = setMatrix(reader, sizes[0], sizes[1]);

        System.out.println(new Solution_1080(sizes[0], sizes[1], matrixA, matrixB).getAnswer());
    }

    public static boolean[][] setMatrix(BufferedReader reader, int column, int row) throws IOException {
        boolean[][] matrix = new boolean[column + 1][row + 1];
        for(int i = 1; i <= column; i++) {
            int[] inputs = Pattern.compile("").splitAsStream("0" + reader.readLine()).mapToInt(Integer::parseInt).toArray();
            for(int j = 1; j <= row; j++) {
               if(inputs[j] == 0) matrix[i][j] = false;
               else matrix[i][j] = true;
            }
        }
        return matrix;
    }
}
