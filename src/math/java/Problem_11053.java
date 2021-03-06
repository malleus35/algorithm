package math.java;

import java.io.*;
import java.util.*;
class Solution_11053 {
    private final int n;
    private final int[] input;
    private final int[] memo;

    Solution_11053(int n, int[] input) {
        this.n = n;
        this.input = input;
        this.memo = new int[n + 1];
    }

    public int getAnswer() {
        for(int i = 1; i <= n; i++) {
            memo[i] = 1;
            for(int j = 1; j <= i; j++) {
                if(input[j] < input[i] && memo[i] <= memo[j]) {
                    memo[i] = memo[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i : memo) {
            max = Math.max(max, i);
        }
        return max;
    }
}

public class Problem_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(("0 " + reader.readLine()).split(" ")).map(Integer::parseInt).mapToInt(item -> item).toArray();
        System.out.println(new Solution_11053(n, input).getAnswer());
    }
}
