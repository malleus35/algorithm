package math.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution_1912 {
    private final int n;
    private final int[] input;
    private final int[][] memo;

    Solution_1912(int n, int[] input) {
        this.n = n;
        this.input = input;
        this.memo = new int[n + 1][2];
        memo[1][0] = input[1];
        memo[1][1] = input[1];
    }

    public int getAnswer() {
        for(int i = 2; i <= n; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1]);
            memo[i][1] = Math.max(memo[i - 1][1] + input[i], input[i]);
        }
        return Math.max(memo[n][0], memo[n][1]);
    }
}

public class Problem_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(("0 " + reader.readLine()).split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        System.out.println(new Solution_1912(n, input).getAnswer());
    }
}
