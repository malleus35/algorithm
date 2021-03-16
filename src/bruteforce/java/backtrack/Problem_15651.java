package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

class Solution_15651 {
    private final int n;
    private final int m;
    private final StringBuilder result;
    private final ArrayList<Integer> nums = new ArrayList<>();

    Solution_15651(int[] input) {
        this.n = input[0];
        this.m = input[1];
        this.result = new StringBuilder();
    }

    private void backTrack(int depth) {
        if(depth == m) {
            for(int i : nums) {
                result.append(i).append(" ");
            }
            result.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++) {
            nums.add(i);
            backTrack(depth + 1);
            nums.remove(depth);
        }
    }
    public String getAnswer() {
        backTrack(0);
        return result.toString();
    }
}

public class Problem_15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution_15651(inputs).getAnswer());
    }
}
