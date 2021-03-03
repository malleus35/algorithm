package graph;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_2331 {
    private final int first;
    private final int multiplier;
    private final int[] nums = new int[250000];

    Solution_2331(int first, int multiplier) {
        this.first = first;
        this.multiplier = multiplier;
    }

    private void dfs(int num) {
        nums[num]++;
        if(nums[num] > 2) return;
        int nextNum = Pattern.compile("").splitAsStream(Integer.toString(num)).mapToInt(Integer::parseInt).map(n -> (int) Math.pow(n, multiplier)).sum();
        dfs(nextNum);
    }

    public int getAnswer() {
        int answer = 0;
        dfs(first);
        for(int i = 1; i <= 250000; i++) {
            if(nums[i] == 1) answer++;
        }

        return answer;
    }
}

public class Problem_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution_2331(input[0], input[1]).getAnswer());
    }
}
