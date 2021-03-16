package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

class Solution_15652 {
    private final int n;
    private final int m;
    private final StringBuilder builder = new StringBuilder();
    private final ArrayList<Integer> nums = new ArrayList<>();

    Solution_15652(int[] inputs) {
        this.n = inputs[0];
        this.m = inputs[1];
    }

    private void backTrack(int present, int depth) {
        if(depth == m) {
            for(int i : nums) {
                builder.append(i).append(" ");
            }
            builder.append("\n");
            return;
        }
        for(int i = present; i <= n; i++) {
            nums.add(i);
            backTrack(i, depth + 1);
            nums.remove(depth);
        }
    }

    public String getAnswer() {
        backTrack(1, 0);
        return builder.toString();
    }
}

public class Problem_15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution_15652(inputs).getAnswer());
    }
}
