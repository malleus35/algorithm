package bruteforce.java.backtrack;

import java.util.*;

class Solution_9663_2 {
    private final int n;
    private final boolean[][] board;
    private final ArrayList<Integer> nums = new ArrayList<>();
    private int answer = 0;

    Solution_9663_2(int n) {
        this.n = n;
        this.board = new boolean[n][n];
    }

    private void backTrack(int depth) {
        if (depth == n) {
            if (nums.size() == n) answer++;
            return;
        }

        for (int myRow = 0; myRow < n; myRow++) {
            if(isRightPlace(depth, myRow)) {
                board[depth][myRow] = true;
                nums.add(myRow);
                backTrack(depth + 1);
                nums.remove(depth);
                board[depth][myRow] = false;
            }
        }
    }

    private boolean isRightPlace(int depth, int myRow) {
        for (int column = 0; column < depth; column++) {
            for (int row = 0; row < n; row++) {
                if (board[column][row]) {
                    if (row == myRow) return false; //같은 열에 있는지 확인
                    if (Math.abs(column - depth) == Math.abs(row - myRow))
                        return false; //대각선 확인
                }
            }
        }
        return true;
    }

    public int getAnswer() {
        backTrack(0);
        return answer;
    }
}

public class Problem_9663_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution_9663_2(n).getAnswer());
    }
}
