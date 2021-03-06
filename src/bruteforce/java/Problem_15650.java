package bruteforce.java;

import java.io.*;
import java.util.regex.*;

class Solution_15650 {
    private final int nums;
    private final int limit;
    private final boolean[] checked;
    private final int[] arr;

    Solution_15650(int nums, int limit) {
        this.nums = nums;
        this.limit = limit;
        this.checked = new boolean[nums + 1];
        this.arr = new int[limit + 1];
    }

    private void backTrack(StringBuilder builder, int min ,int depth) {
        if(depth >= limit + 1) {
            for(int i = 1; i <= limit; i++) {
                builder.append(arr[i]).append(" ");
            }
            builder.append("\n");
            return;
        }
        for(int i = min; i <= nums; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            arr[depth] = i;
            backTrack(builder, i + 1, depth + 1);
            checked[i] = false;
        }
    }

    public String getAnswer() {
        StringBuilder builder = new StringBuilder();
        backTrack(builder, 1, 1);
        return builder.toString();
    }
}

public class Problem_15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_15650(inputs[0], inputs[1]).getAnswer());
    }
}
