package bruteforce.java;

import java.io.*;
import java.util.regex.*;

class Solution_15649 {
    private final int nums;
    private final int limit;
    private final boolean[] visited;
    private final int[] arr;

    Solution_15649(int nums, int limit) {
        this.nums = nums;
        this.limit = limit;
        this.visited = new boolean[nums + 1];
        this.arr = new int[limit + 1];
    }

    private void nextPermutation(StringBuilder builder, int depth) {
        if(depth == limit + 1) {
            for(int i = 1; i <= limit; i++) {
                builder.append(arr[i]).append(" ");
            }
            builder.append("\n");
            return;
        }
        for(int i = 1; i <= nums; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            nextPermutation(builder,depth + 1);
            visited[i] = false;
        }
    }

    public String getAnswer() {
        StringBuilder builder = new StringBuilder();
        nextPermutation(builder, 1);
        return builder.toString();
    }
}

public class Problem_15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_15649(inputs[0], inputs[1]).getAnswer());
    }
}
