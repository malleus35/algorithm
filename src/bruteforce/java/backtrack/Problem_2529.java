package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

/*
    부등호라서 숫자의 개수보다 하나가 적어서 nums.get(depth - 1)과 inputs[depth - 1]을 비교해야 하는 것을 주의하자
    숫자가 10개라서 98억까지 가능하므로 Long으로 해주어야 한다.
 */

class Solution_2529 {
    private final int numOfSign;
    private final String[] inputs;
    private final StringBuilder builder = new StringBuilder();
    private final ArrayList<Integer> nums = new ArrayList<>();
    private final ArrayList<String> results = new ArrayList<>();

    Solution_2529(int numOfSign, String[] inputs) {
        this.numOfSign = numOfSign;
        this.inputs = inputs;
    }

    private void backTrack(int depth) {
        if (depth == numOfSign + 1) {
            StringBuilder madeNum = new StringBuilder();
            if (nums.size() == numOfSign + 1) {
                for (int i : nums) {
                    madeNum.append(i);
                }
                results.add(madeNum.toString());
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (nums.contains(i)) continue;
            if (depth > 0) {
                if (inputs[depth - 1].equals("<")) {
                    if (nums.get(depth - 1) > i) continue;
                } else if (inputs[depth - 1].equals(">")) {
                    if (nums.get(depth - 1) < i) continue;
                }
            }
            nums.add(i);
            backTrack(depth + 1);
            nums.remove(depth);
        }
    }

    public String getAnswer() {
        backTrack(0);
        String max = "-9876543210";
        String min = "9876543210";
        for (String i : results) {
            if (Long.parseLong(i) > Long.parseLong(max)) {
                max = i;
            }
            if (Long.parseLong(i) < Long.parseLong(min)) {
                min = i;
            }
        }
        builder.append(max).append("\n");
        builder.append(min).append("\n");
        return builder.toString();
    }
}

public class Problem_2529 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfSign = Integer.parseInt(reader.readLine());
        String[] inputs = reader.readLine().split(" ");
        System.out.println(new Solution_2529(numOfSign, inputs).getAnswer());
    }
}
