package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

/*
    오름차순이나 내림차순 등의 조건이 들어가면, 방문을 boolean등으로 확인할 것.
    boolean 배열 없이도 확인이 가능한가? -> 확인 필요
    arraylist.contain을 이용해도 확인가능(속도와 메모리는 더 느리긴 함)
 */
class Solution_15654 {
    private final int n;
    private final int m;
    private final int[] inputNums;
    private final StringBuilder builder = new StringBuilder();
    private final ArrayList<Integer> nums = new ArrayList<>();

    Solution_15654(int[] nAndM, int[] inputNums) {
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
            if(nums.contains(inputNums[i])) continue;
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

public class Problem_15654 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] inputNums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(new Solution_15654(nAndM, inputNums).getAnswer());
    }
}
