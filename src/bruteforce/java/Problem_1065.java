package bruteforce.java;

import java.util.*;
import java.io.*;

class Solution_1065 {
    private final int input;

    Solution_1065(int input) {
        this.input = input;
    }

    public int getAnswer() {
        int answer = 0;
        for(int i = 1; i <= input; i++) {
            if(i >= 1 && i <= 9) answer++;
            else {
                int[] tmp = Arrays.stream((i + "").split("")).mapToInt(Integer::parseInt).toArray();
                int len = tmp.length;
                boolean flag = true;
                for(int j = 1; j < len - 1; j++) {
                    if(tmp[j] - tmp[j - 1] != tmp[j + 1] - tmp[j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }
}

public class Problem_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        System.out.println(new Solution_1065(input).getAnswer());
    }
}
