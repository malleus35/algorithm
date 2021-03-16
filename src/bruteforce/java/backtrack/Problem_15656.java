package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

class Solution_15656 {
    private final int n;
    private final int m;
    private final int[] inputNums;
    private final StringBuilder builder = new StringBuilder();
    private final ArrayList<Integer> nums = new ArrayList<>();

    Solution_15656(int[] nAndM, int[] inputNums) {
        this.n = nAndM[0];
        this.m = nAndM[1];
        this.inputNums = inputNums;
    }

    private void backTrack(int depth) {
        if(depth == m) {
            for(int i : nums) {
                builder.append(i).append(" ");
            }
            builder.append("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            nums.add(inputNums[i]);
            backTrack(depth + 1);
            nums.remove(depth);
        }
    }

    public String getAnswer() {
        backTrack( 0);
        return builder.toString();
    }
}

public class Problem_15656 {
    public static int[] getIntArrToString (String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] getSortedIntArrToString (String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = getIntArrToString(reader.readLine());
        int[] inputNums = getSortedIntArrToString(reader.readLine());
        System.out.println(new Solution_15656(nAndM, inputNums).getAnswer());
    }
}
