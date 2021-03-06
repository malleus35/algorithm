package bruteforce.java;

import java.util.*;
import java.io.*;

class Solution_1174 {
    private final int input;
    private int order = 1;
    private final String MAX_VALUE = "9876543210";
    private final int MAX_DEPTH = 11;
    private final ArrayList<Integer> nums;

    Solution_1174(int input) {
        this.input = input;
        this.nums = new ArrayList<>();
    }

    private void backTrack(boolean isFirstZero, int lastNum, int depth) {
        if(isFirstZero) return;
        if(depth == MAX_DEPTH) {
            for(int i = 1; i < 11; i++) {

            }
        }
        if(order == input) {

        }
        for(int i = 0; i < lastNum; i++) {
            if(!isFirstZero) {
                if(depth == 0 && i == 0) {
                    nums.add(i);
                    order++;
                    backTrack(true, i,depth + 1);
                    nums.remove(depth);
                } else {
                    nums.add(i);
                    order++;
                    backTrack(false, i,depth + 1);
                    nums.remove(depth);
                }
            }
        }

    }
    public int getAnswer() {
        int answer = 0;
        backTrack(false, 10,0);
        return answer;
    }
}

public class Problem_1174 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        System.out.println(new Solution_1174(input).getAnswer());
    }
}
