package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

class Solution_15655 {
    private final int n;
    private final int m;
    private final int[] inputNums;
    private final StringBuilder builder = new StringBuilder();
    private final ArrayList<Integer> nums = new ArrayList<>();

    Solution_15655(int[] nAndM, int[] inputNums) {
        this.n = nAndM[0];
        this.m = nAndM[1];
        this.inputNums = inputNums;
    }

    private void backTrack(int presentIndex, int depth) {
        if(depth == m) {
            for(int i : nums) {
                builder.append(i).append(" ");
            }
            builder.append("\n");
            return;
        }
        for(int i = presentIndex; i < n; i++) {
            nums.add(inputNums[i]);
            backTrack(i + 1,depth  + 1);
            nums.remove(depth);
        }
    }

    public String getAnswer() {
        backTrack(0, 0);
        return builder.toString();
    }
}

public class Problem_15655 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] inputNums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(new Solution_15655(nAndM, inputNums).getAnswer());
    }
}
