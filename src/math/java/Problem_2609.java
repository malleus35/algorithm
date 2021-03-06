package math.java;

import java.util.*;
import java.io.*;

class Solution_2609 {
    private final int[] input;

    Solution_2609(int[] input) {
        this.input = input;
    }

    public String getAnswer() {
        StringBuilder builder = new StringBuilder();
        int gcd = this.getGCD(input[0], input[1]);
        builder.append(gcd).append("\n");
        int lcm = this.getLCM(input[0], input[1], gcd);
        builder.append(lcm).append("\n");
        return builder.toString();
    }

    private int getLCM(int left, int right, int gcd) {
        return 0;
    }

    private int getGCD(int left, int right) {
        int a = Math.max(left, right);
        int b = Math.min(left, right);

        if (a % b == 0) {
            return b;
        }
        return 1;
    }
}

public class Problem_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_2609(input).getAnswer());
    }
}

/*
12 42
42 / 12 = 3
42 % 12 = 6

12 / 6 = 2
12 % 6 = 0

75 125
125 / 75 = 1
125 % 75 = 50

75 / 50 = 1
75 % 50 = 25

50 / 25 = 2
50 % 25 = 0
 */