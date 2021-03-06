package math.java;

import java.io.*;
import java.util.*;

class Solution_11430 {
    private final int[] input;
    Solution_11430(int[] input) {
        this.input = input;
    }

    public String getAnswer() {
        int a = input[0];
        int b = input[1];
        int c = input[2];
        StringBuilder builder = new StringBuilder();
        builder.append((a + b) % c).append("\n");
        builder.append(((a % c) + (b % c)) % c).append("\n");
        builder.append((a * b) % c).append("\n");
        builder.append(((a % c) * (b % c)) % c).append("\n");
        return builder.toString();
    }
}

public class Problem_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_11430(input).getAnswer());
    }
}
