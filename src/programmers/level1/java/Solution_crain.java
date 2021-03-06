package programmers.level1.java;

import java.util.*;

public class Solution_crain {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        int[] tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                if (tops[j] != -1) continue;
                tops[j] = i;
            }
        }
        for (int i = 0; i < N; i++) {
            if (tops[i] == -1) tops[i] = N;
        }
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            if (tops[move - 1] >= N) continue;
            int present = board[tops[move - 1]][move - 1];
            if (stack.isEmpty()) {
                stack.push(present);
                tops[move - 1]++;
                continue;
            }
            int top = stack.peek();

            if (top == present) {
                answer += 2;
                tops[move - 1]++;
                stack.pop();
            } else {
                stack.push(present);
                tops[move - 1]++;
            }
        }
        return answer;
    }
}
