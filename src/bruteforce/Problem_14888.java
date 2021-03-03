package bruteforce;

import java.util.*;
import java.io.*;
import java.util.regex.*;

class Solution_14888 {
    private final int len;
    private final int[] nums;
    private final int[] operators;
    private final ArrayList<Integer> results;
    private final boolean[] visited;

    Solution_14888(int len, int[] nums, int[] operators) {
        this.len = len;
        this.nums = nums;
        this.operators = operators;
        this.results = new ArrayList<>();
        this.visited = new boolean[len + 1];
    }

    private void backTrack(int depth, int prevResult) {
        int prevOp = -1;
        if(visited[depth]) return;
        visited[depth] = true;
        if(depth == len) {
            results.add(prevResult);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int tmpResult = prevResult;
            if(operators[i] <= 0) continue;
            switch(i) {
                case 0 :
                    tmpResult += nums[depth + 1];
                    prevOp = 0;
                    operators[prevOp]--;
                    break;
                case 1 :
                    tmpResult -= nums[depth + 1];
                    prevOp = 1;
                    operators[prevOp]--;
                    break;
                case 2 :
                    tmpResult *= nums[depth + 1];
                    prevOp = 2;
                    operators[prevOp]--;
                    break;
                case 3:
                    if(nums[depth + 1] < 0) {
                        int tmp = nums[depth + 1] * -1;
                        tmpResult /= tmp;
                        tmpResult *= -1;
                    } else tmpResult /= nums[depth + 1];
                    prevOp = 3;
                    operators[prevOp]--;
            }
            backTrack(depth + 1, tmpResult);
            visited[depth + 1] = false;
            operators[prevOp]++;
        }
    }
    public String getAnswer() {
        StringBuilder resultBuilder = new StringBuilder();
        backTrack(1, nums[1]);
        resultBuilder.append(results.stream().max(Comparator.naturalOrder()).get()).append("\n");
        resultBuilder.append(results.stream().min(Comparator.naturalOrder()).get()).append("\n");
        return resultBuilder.toString();
    }
}

public class Problem_14888 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).toArray();
        int[] operators = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_14888(len, nums, operators).getAnswer());
    }
}
