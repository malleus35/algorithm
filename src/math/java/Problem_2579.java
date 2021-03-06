package math.java;

import java.util.*;

class Solution_2579 {
    private final int n;
    private final int[] input;
    private final int[][] memo;

    Solution_2579(int n, int[] input) {
        this.n = n;
        this.input = input;
        this.memo = new int[n + 1][2];

        memo[1][0] = input[1];
        memo[1][1] = input[1];
    }

    public int getAnswer() {
        for(int i = 2; i <= n; i++) {
            memo[i][0] = Math.max(memo[i - 2][0], memo[i - 2][1])+ input[i];
            memo[i][1] = memo[i - 1][0] + input[i];
        }
        return Math.max(memo[n][0], memo[n][1]);
    }
}

public class Problem_2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n + 1];
        scanner.nextLine();
        for(int i = 1; i <= n; i++) {
            input[i] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println(new Solution_2579(n, input).getAnswer());
    }
}
